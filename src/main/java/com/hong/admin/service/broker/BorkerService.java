package com.hong.admin.service.broker;

import com.hong.admin.dao.entity.Page;
import com.hong.admin.dao.entity.broker.Broker;
import com.hong.admin.dao.entity.broker.BrokerExample;
import com.hong.admin.dao.entity.broker.Company;
import com.hong.admin.dao.entity.broker.CompanyExample;
import com.hong.admin.dao.entity.nurse.Nurse;
import com.hong.admin.dao.entity.nurse.NurseExample;
import com.hong.admin.dao.entity.nurse.NurseImport;
import com.hong.admin.dao.entity.nurse.NurseImportExample;
import com.hong.admin.dao.mapper.broker.BrokerMapper;
import com.hong.admin.dao.mapper.broker.CompanyMapper;
import com.hong.admin.dao.mapper.nurse.NurseImportMapper;
import com.hong.admin.dao.mapper.nurse.NurseMapper;
import com.hong.admin.query.entity.admin.AdminQueryEntity;
import com.hong.admin.util.Constant;
import com.hong.admin.util.GeneralUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syline on 2017/7/22.
 */
@Service
public class BorkerService {

    @Autowired
    private BrokerMapper brokerMapper;

    @Autowired
    private NurseImportMapper importMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private NurseMapper nurseMapper;

    public Map selectBrokerInfos(AdminQueryEntity entity, Page page) {
        BrokerExample example = new BrokerExample();
        BrokerExample.Criteria criteria = example.createCriteria();
//        if (entity){
//            criteria
//        }

        Map result = new HashMap<>();
        List<Broker> map = brokerMapper.selectByExample(example, new PageBounds(1, 100));
        result.put("results", map);
        return result;
    }


    public Map getIdByPhone(String phone) {
        Map map = new HashMap<>();
        int id = 0;
        BrokerExample example = new BrokerExample();
        example.createCriteria().andPhoneNumberEqualTo(phone);
        List<Broker> list = brokerMapper.selectByExample(example, new PageBounds(1, 2));
        if (list.size() > 0) {
            id = list.get(0).getId();
            map.put("id", id);
            map.put("name", list.get(0).getName());
        }
        return map;
    }


    /**
     * 上传excel文件到临时目录后并开始解析
     *
     * @param fileName
     * @param mfile
     * @return
     */
    public String batchImport(String fileName, MultipartFile mfile, int brokerId) {
        //初始化输入流
        InputStream is = null;
        try {

            //根据新建的文件实例化输入流
            is = mfile.getInputStream();

            //根据版本选择创建Workbook的方式
            Workbook wb = null;
            //根据文件名判断文件是2003版本还是2007版本
            if (GeneralUtil.isExcel2007(fileName)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = new HSSFWorkbook(is);
            }
            //读取excel
            return readExcelValue(wb, brokerId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return "导入出错！请检查数据格式！";
    }


    /**
     * 解析Excel里面的数据
     *
     * @param wb
     * @return
     */
    private String readExcelValue(Workbook wb, int brokerId) {
        //错误信息接收器
        String errorMsg = "";
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        //得到Excel的行数
        int totalRows = sheet.getPhysicalNumberOfRows();
        //总列数
        int totalCells = 0;
        //得到Excel的列数(前提是有行数)，从第二行算起
        if (totalRows >= 2 && sheet.getRow(1) != null) {
            totalCells = sheet.getRow(1).getPhysicalNumberOfCells();
        }
        List<NurseImport> nurseList = new ArrayList<NurseImport>();
        NurseImport nurse;

        String br = "<br/>";

        //循环Excel行数,从第二行开始。标题不入库
        for (int r = 1; r < totalRows; r++) {
            String rowMessage = "";
            Row row = sheet.getRow(r);
            if (row == null) {
                errorMsg += br + "第" + (r + 1) + "行数据有问题，请仔细检查！";
                continue;
            }
            nurse = new NurseImport();
            nurse.setBrokerId(brokerId);

            //循环Excel的列
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    switch (c) {
                        case 0:
                            nurse.setName(cell.getStringCellValue());
                            break;
                        case 1:
                            String sex = cell.getStringCellValue();
                            if (sex.equals("男")) {
                                sex = "1";
                            } else {
                                sex = "0";
                            }
                            nurse.setSex(sex);
                            break;
                        case 2:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            nurse.setPhone(cell.getStringCellValue());
                            break;
                        case 3:
                            nurse.setIdCard(cell.getStringCellValue());
                            break;
                        case 4:
                            nurse.setAge((int) cell.getNumericCellValue());
                            break;
                        case 5:
                            nurse.setZodiac(cell.getStringCellValue());
                            break;
                        case 6:
                            nurse.setXl(cell.getStringCellValue());
                            break;
                        case 7:
                            nurse.setMz(cell.getStringCellValue());
                            break;
                        case 8:
                            nurse.setHeight((int) (cell.getNumericCellValue()));
                            break;
                        case 9:
                            nurse.setWeight((int) (cell.getNumericCellValue()));
                            break;
                        case 10:
                            nurse.setJkzk(cell.getStringCellValue());
                            break;
                        case 11:
                            nurse.setExperience(cell.getNumericCellValue());
                            break;
                        case 12:
                            nurse.setAddress(cell.getStringCellValue());
                            break;
                        case 13:
                            String marr = cell.getStringCellValue();
                            if (marr.equals("已婚")) {
                                marr = "1";
                            } else {
                                marr = "0";
                            }
                            nurse.setMarriage(marr);
                            break;
                        case 14:
                            nurse.setYwxh(cell.getStringCellValue());
                            break;
                        case 15:
                            nurse.setYy(cell.getStringCellValue());
                            break;
                        case 16:
                            nurse.setCookie(cell.getStringCellValue());
                        case 17:
                            nurse.setWork(cell.getStringCellValue());
                            break;
                        case 18:
                            nurse.setSydq(cell.getStringCellValue());
                            break;
                        case 19:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            nurse.setSsjjr(cell.getStringCellValue());
                            break;
                        case 20:
                            nurse.setSsgs(cell.getStringCellValue());
                            break;
                        case 21:
                            nurse.setSalary((int) (cell.getNumericCellValue()));
                            break;
                        case 22:
                            nurse.setHtStartDate(cell.getDateCellValue());
                            break;
                        case 23:
                            nurse.setHtEndDate(cell.getDateCellValue());
                            break;

                        case 24:
                            nurse.setKhyh(cell.getStringCellValue());
                            break;
                        case 25:
                            nurse.setBankCode(cell.getStringCellValue());
                            break;
                        case 26:
                            nurse.setType(cell.getStringCellValue());
                            break;
                        case 27:
                            nurse.setLevel(cell.getStringCellValue());
                            break;
                        case 28:
                            nurse.setGspj(cell.getStringCellValue());
                            break;
                        case 29:
                            nurse.setSzdq(cell.getStringCellValue());
                            break;
                        case 30:
                            nurse.setFwdq(cell.getStringCellValue());
                            break;
                    }
                } else {
                    rowMessage += "第" + (c + 1) + "列数据有问题，请仔细检查；";
                }
            }
            nurseList.add(nurse);
            //拼接每行的错误提示
            if (!StringUtils.isEmpty(rowMessage)) {
                errorMsg += br + "第" + (r + 1) + "行，" + rowMessage;
            }
        }


        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(
                ExecutorType.BATCH, false);


        int j = 0;
        NurseImportMapper nurseImportMapper = session.getMapper(NurseImportMapper.class);
        try {
            for (NurseImport entity : nurseList) {
                nurseImportMapper.insertSelective(entity);
                if (j % 100 == 0 || j == nurseList.size() - 1) {
                    //手动每1000个一提交，提交后无法回滚
                    session.commit();
                    //清理缓存，防止溢出
                    session.clearCache();
                }
                j++;
            }
        } catch (
                Exception e
                ) {
//没有提交的数据可以回滚
            session.rollback();
        } finally

        {
            session.close();
        }


        String successMsg = "导入成功，共" + j + "条数据！";

        return errorMsg + successMsg;
    }


    public Map getBrokerInfo(int brokerId) {
        return brokerMapper.selectBrokerInfoById(brokerId);
    }


    public int updateInfo(Broker broker) {
        String comName = broker.getCompanyName();
        String address = broker.getAddress();

        CompanyExample example = new CompanyExample();
        example.createCriteria().andNameEqualTo(comName).andAddressEqualTo(address);

        List<Company> list = companyMapper.selectByExample(example);
        int companyId = 0;
        if (list.size() > 0) {
            Company company = list.get(0);
            companyId = company.getId();
        } else {
            Company company = new Company();
            company.setAddress(address);
            company.setName(comName);
            companyMapper.insertSelective(company);
            companyId = company.getId();
        }
        broker.setCompanyId(companyId);
        return brokerMapper.updateByPrimaryKeySelective(broker);
    }


    /**
     * 检查密码是否正确
     *
     * @param pwd
     * @return
     */
    public boolean isPwdOk(int brokerId, String pwd) {
        boolean flag = false;
        BrokerExample example = new BrokerExample();
        example.createCriteria().andIdEqualTo(brokerId).andPasswordEqualTo(pwd);
        PageList<Broker> list = brokerMapper.selectByExample(example, new PageBounds(1, 10));
        if (list.size() > 0) {
            flag = true;
        }
        return flag;
    }


    /**
     * 修改密码
     *
     * @return
     */
    public int updatePwdByBrokerId(int brokerId, String newPwd) {
        Broker broker = new Broker();
        broker.setId(brokerId);
        broker.setPassword(newPwd);
        return brokerMapper.updateByPrimaryKeySelective(broker);
    }


    public void submitImportBySelect(String ids) {
        String[] idArray;
        if (ids.indexOf(",") > -1) {
            idArray = ids.split(",");
        } else {
            idArray = new String[]{ids};
        }


        List<NurseImport> updateImports = new ArrayList<>();
        List<Nurse> nurses = new ArrayList<>();

        if (idArray != null) {
            for (String idstr : idArray) {
                int importId = Integer.parseInt(idstr);
                NurseImport nurseImport = importMapper.selectByPrimaryKey(importId);
                if (!nurseImport.getFlag().equals("1")) {
                    String idcard = nurseImport.getIdCard();
                    String phone = nurseImport.getPhone();

                    NurseExample example = new NurseExample();
                    example.createCriteria().andIdcardEqualTo(idcard);

                    NurseExample example1 = new NurseExample();
                    example1.createCriteria().andPhoneNumberEqualTo(phone);

                    String jjr = nurseImport.getSsjjr();

                    String result = "";
                    BrokerExample brokerExample = new BrokerExample();
                    brokerExample.createCriteria().andPhoneNumberEqualTo(jjr);
                    List<Broker> brokers = brokerMapper.selectByExample(brokerExample, new PageBounds(1, 10));

                    if (brokers != null && brokers.size() > 0) {
                        List<Nurse> list = nurseMapper.selectByExample(example, new PageBounds(1, 1));
                        List<Nurse> list1 = nurseMapper.selectByExample(example, new PageBounds(1, 1));
                        if (list.size() > 0) {
                            result = "身份证重复";
                        }
                        if (list1.size() > 0) {
                            result += "手机号重复";
                        }

                        if (!org.apache.commons.lang3.StringUtils.isEmpty(result)) {
                            NurseImport entity = new NurseImport();
                            entity.setId(importId);
                            entity.setResult("提交失败," + result);
                            entity.setFlag("2");
                            updateImports.add(entity);
//                        importMapper.updateByPrimaryKeySelective(entity);
                        } else {
                            Nurse nurse = new Nurse();

                            String pwdmw = phone.substring(phone.length() - 4, phone.length());
                            String pwd = DigestUtils.md5DigestAsHex(pwdmw.getBytes());
                            nurse.setBrokerId(nurseImport.getBrokerId());
                            nurse.setPassword(pwd);
                            nurse.setName(nurseImport.getName());
                            nurse.setSex(nurseImport.getSex());
                            nurse.setPhoneNumber(nurseImport.getPhone());
                            nurse.setIdcard(nurseImport.getIdCard());
                            nurse.setAge(nurseImport.getAge());
                            nurse.setZodiac(nurseImport.getZodiac());
                            nurse.setXl(nurseImport.getXl());
                            nurse.setMz(nurseImport.getMz());
                            nurse.setHigh(nurseImport.getHeight());
                            nurse.setWeight(nurseImport.getWeight());
                            nurse.setHealth(nurseImport.getJkzk());
                            nurse.setExperience(nurseImport.getExperience());
                            nurse.setHomeAddress(nurseImport.getAddress());
                            nurse.setHy(nurseImport.getMarriage());
                            nurse.setYy(nurseImport.getYy());
                            nurse.setPr(nurseImport.getCookie());
                            nurse.setGz(nurseImport.getWork());
                            nurse.setSydq(nurseImport.getSydq());
                            nurse.setSsjjr(nurseImport.getSsjjr());
                            nurse.setSsgs(nurseImport.getSsgs());
                            nurse.setSalary(nurseImport.getSalary());
                            nurse.setHtStartDate(nurseImport.getHtStartDate());
                            nurse.setHtEndDate(nurseImport.getHtEndDate());
                            nurse.setKhyh(nurseImport.getKhyh());
                            nurse.setBankCode(nurseImport.getBankCode());
                            nurse.setType(GeneralUtil.getTypeIdByName(nurseImport.getType()));
                            nurse.setLevel(nurseImport.getLevel());
                            nurse.setGspj(nurseImport.getGspj());
                            String szdq = nurseImport.getSzdq();
//                            if (!org.apache.commons.lang3.StringUtils.isEmpty(szdq)) {
//                                nurse.setLocationArea(GeneralUtil.getCityIdByName(szdq));
//                            }
                            nurse.setLocationArea(szdq);
                            String fwdq = nurseImport.getFwdq();
                            if (!org.apache.commons.lang3.StringUtils.isEmpty(fwdq)) {
                                nurse.setServiceArea(GeneralUtil.getCityIdByName(fwdq));
                            }
                            nurse.setYwxh(nurseImport.getYwxh());
                            nurses.add(nurse);


                            NurseImport entity = new NurseImport();
                            entity.setId(importId);
                            entity.setResult("提交成功");
                            entity.setFlag("1");
                            updateImports.add(entity);
                        }
                    } else {
                        NurseImport entity = new NurseImport();
                        entity.setId(importId);
                        entity.setResult(" 提交失败,所属经纪人不存在");
                        entity.setFlag("2");
                        updateImports.add(entity);
                    }
                }


                SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(
                        ExecutorType.BATCH, false);

                NurseImportMapper nurseImportMapper = session.getMapper(NurseImportMapper.class);
                NurseMapper nurseMapperBatch = session.getMapper(NurseMapper.class);

                int j = 0;
                int k = 0;
                try {
                    for (Nurse entity : nurses) {
                        nurseMapperBatch.insertSelective(entity);
                        if (j % 100 == 0 || j == nurses.size() - 1) {
                            //手动每1000个一提交，提交后无法回滚
                            session.commit();
                            //清理缓存，防止溢出
                            session.clearCache();
                        }
                        j++;
                    }
                    for (NurseImport entity : updateImports) {
                        nurseImportMapper.updateByPrimaryKeySelective(entity);
                        if (k % 100 == 0 || k == updateImports.size() - 1) {
                            //手动每1000个一提交，提交后无法回滚
                            session.commit();
                            //清理缓存，防止溢出
                            session.clearCache();
                        }
                        k++;
                    }

                } catch (
                        Exception e
                        ) {
//没有提交的数据可以回滚
                    session.rollback();
                } finally

                {
                    session.close();
                }
            }
        }

    }


    public void submitImportByAll(int brokerId) {
        NurseImportExample nurseImportExample = new NurseImportExample();
        nurseImportExample.createCriteria().andBrokerIdEqualTo(brokerId).andFlagNotEqualTo("1");

        List<NurseImport> lists = importMapper.selectByExampleNoPage(nurseImportExample);


        List<NurseImport> updateImports = new ArrayList<>();
        List<Nurse> nurses = new ArrayList<>();

        if (lists != null && lists.size() > 0) {
            for (NurseImport nurseImport : lists) {
                int importId = nurseImport.getId();
                String idcard = nurseImport.getIdCard();
                String phone = nurseImport.getPhone();

                NurseExample example = new NurseExample();
                example.createCriteria().andIdcardEqualTo(idcard);

                NurseExample example1 = new NurseExample();
                example1.createCriteria().andPhoneNumberEqualTo(phone);

                String jjr = nurseImport.getSsjjr();

                String result = "";
                BrokerExample brokerExample = new BrokerExample();
                brokerExample.createCriteria().andPhoneNumberEqualTo(jjr);
                List<Broker> brokers = brokerMapper.selectByExample(brokerExample, new PageBounds(1, 10));

                if (brokers != null && brokers.size() > 0) {
                    List<Nurse> list = nurseMapper.selectByExample(example, new PageBounds(1, 1));
                    List<Nurse> list1 = nurseMapper.selectByExample(example, new PageBounds(1, 1));
                    if (list.size() > 0) {
                        result = "身份证重复";
                    }
                    if (list1.size() > 0) {
                        result += "手机号重复";
                    }

                    if (!org.apache.commons.lang3.StringUtils.isEmpty(result)) {
                        NurseImport entity = new NurseImport();
                        entity.setId(importId);
                        entity.setResult("提交失败," + result);
                        entity.setFlag("2");
                        updateImports.add(entity);
//                        importMapper.updateByPrimaryKeySelective(entity);
                    } else {
                        Nurse nurse = new Nurse();
                        String pwdmw = phone.substring(phone.length() - 4, phone.length());
                        String pwd = DigestUtils.md5DigestAsHex(pwdmw.getBytes());
                        nurse.setBrokerId(nurseImport.getBrokerId());
                        nurse.setPassword(pwd);
                        nurse.setName(nurseImport.getName());
                        nurse.setSex(nurseImport.getSex());
                        nurse.setPhoneNumber(nurseImport.getPhone());
                        nurse.setIdcard(nurseImport.getIdCard());
                        nurse.setAge(nurseImport.getAge());
                        nurse.setZodiac(nurseImport.getZodiac());
                        nurse.setXl(nurseImport.getXl());
                        nurse.setMz(nurseImport.getMz());
                        nurse.setHigh(nurseImport.getHeight());
                        nurse.setWeight(nurseImport.getWeight());
                        nurse.setHealth(nurseImport.getJkzk());
                        nurse.setExperience(nurseImport.getExperience());
                        nurse.setHomeAddress(nurseImport.getAddress());
                        nurse.setHy(nurseImport.getMarriage());
                        nurse.setYy(nurseImport.getYy());
                        nurse.setPr(nurseImport.getCookie());
                        nurse.setGz(nurseImport.getWork());
                        nurse.setSydq(nurseImport.getSydq());
                        nurse.setSsjjr(nurseImport.getSsjjr());
                        nurse.setSsgs(nurseImport.getSsgs());
                        nurse.setSalary(nurseImport.getSalary());
                        nurse.setHtStartDate(nurseImport.getHtStartDate());
                        nurse.setHtEndDate(nurseImport.getHtEndDate());
                        nurse.setKhyh(nurseImport.getKhyh());
                        nurse.setBankCode(nurseImport.getBankCode());
                        nurse.setType(GeneralUtil.getTypeIdByName(nurseImport.getType()));
                        nurse.setLevel(nurseImport.getLevel());
                        nurse.setGspj(nurseImport.getGspj());
                        String szdq = nurseImport.getSzdq();
//                        if (!org.apache.commons.lang3.StringUtils.isEmpty(szdq)) {
//                            nurse.setLocationArea(GeneralUtil.getCityIdByName(szdq));
//                        }
                        nurse.setLocationArea(szdq);
                        String fwdq = nurseImport.getFwdq();
                        if (!org.apache.commons.lang3.StringUtils.isEmpty(fwdq)) {
                            nurse.setServiceArea(GeneralUtil.getCityIdByName(fwdq));
                        }
                        nurse.setYwxh(nurseImport.getYwxh());
                        nurses.add(nurse);
                        NurseImport entity = new NurseImport();
                        entity.setId(importId);
                        entity.setResult("提交成功");
                        entity.setFlag("1");
                        updateImports.add(entity);
                    }
                } else {
                    NurseImport entity = new NurseImport();
                    entity.setId(importId);
                    entity.setResult(" 提交失败,所属经纪人不存在");
                    entity.setFlag("2");
                    updateImports.add(entity);
                }
            }


            SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(
                    ExecutorType.BATCH, false);

            NurseImportMapper nurseImportMapper = session.getMapper(NurseImportMapper.class);
            NurseMapper nurseMapperBatch = session.getMapper(NurseMapper.class);

            int j = 0;
            int k = 0;
            try {
                for (Nurse entity : nurses) {
                    nurseMapperBatch.insertSelective(entity);
                    if (j % 100 == 0 || j == nurses.size() - 1) {
                        //手动每1000个一提交，提交后无法回滚
                        session.commit();
                        //清理缓存，防止溢出
                        session.clearCache();
                    }
                    j++;
                }
                for (NurseImport entity : updateImports) {
                    nurseImportMapper.updateByPrimaryKeySelective(entity);
                    if (k % 100 == 0 || k == updateImports.size() - 1) {
                        //手动每1000个一提交，提交后无法回滚
                        session.commit();
                        //清理缓存，防止溢出
                        session.clearCache();
                    }
                    k++;
                }

            } catch (
                    Exception e
                    ) {
//没有提交的数据可以回滚
                session.rollback();
            } finally

            {
                session.close();
            }


        }

    }


    /**
     * 获取经纪人信息
     *
     * @return
     */
    public Map selectBrokerInfos(String param, int currPage) {
        Map result = new HashMap<>();
        PageList<Map> map = brokerMapper.selectBrokerInfoByParam(param, new PageBounds(currPage, Constant.PageKey.LIMIT));
        int currpage = map.getPaginator().getPage();
        int total = map.getPaginator().getTotalPages();


        for (Map entity : map) {
            int brokerId = (int) entity.get("id");
            if (isCanDelete(brokerId)) {
                entity.put("delFlag", "1");
            } else {
                entity.put("delFlag", "0");
            }
        }

        result.put("results", (List) map);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }


    public boolean isCanDelete(int brokerId) {
        boolean flag = true;
        NurseExample example = new NurseExample();
        example.createCriteria().andBrokerIdEqualTo(brokerId).andStatusNotEqualTo("99");
        List<Nurse> list = nurseMapper.selectByExample(example, new PageBounds(1, 10));
        if (list.size() > 0) {
            flag = false;
        }
        return flag;
    }


    public int deleteBrokerById(int brokerId) {
        Broker broker = new Broker();
        broker.setId(brokerId);
        broker.setStatus("0");
        int flag = brokerMapper.updateByPrimaryKeySelective(broker);
        return flag;
    }


    public int deleteBrokderByIds(String brokerIds) {
        int flag = 0;
        String[] ids = brokerIds.split(",");
        for (String id : ids) {
            Broker broker = new Broker();
            broker.setId(Integer.parseInt(id));
            broker.setStatus("0");
            flag += brokerMapper.updateByPrimaryKeySelective(broker);
        }
        return flag;
    }


    public int addInfo(Broker broker) {
        String comName = broker.getCompanyName();
        String address = broker.getAddress();

        CompanyExample example = new CompanyExample();
        example.createCriteria().andNameEqualTo(comName).andAddressEqualTo(address);

        List<Company> list = companyMapper.selectByExample(example);
        int companyId = 0;
        if (list.size() > 0) {
            Company company = list.get(0);
            companyId = company.getId();
        } else {
            Company company = new Company();
            company.setAddress(address);
            company.setName(comName);
            companyMapper.insertSelective(company);
            companyId = company.getId();
        }
        broker.setCompanyId(companyId);

        String phone = broker.getPhoneNumber();
        String pwdmw = phone.substring(phone.length() - 4, phone.length());
        String pwd = DigestUtils.md5DigestAsHex(pwdmw.getBytes());
        broker.setPassword(pwd);


        return brokerMapper.insertSelective(broker);
    }


    public int updatePwd(String phoneNum, String pwd) {
        int count = 0;
        count = brokerMapper.updateByPhoneNum(pwd, phoneNum);
        return count;
    }


}
