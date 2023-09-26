package com.baidu.controller;

import com.baidu.pojo.Attributes;
import com.baidu.pojo.Pokemen;
import com.baidu.pojo.QeVo;
import com.baidu.service.PokemenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping("pokemen")
public class PokemenController {
    @Autowired
    private PokemenService pokemenService;

    @RequestMapping("toPokemen")
    public String toPokemen(Model model, QeVo qeVo,
                            @RequestParam(required = true, defaultValue = "1") Integer pageNum,
                            @RequestParam(required = false, defaultValue = "3") Integer pageSize) {
        // 分页的信息
        PageHelper.startPage(pageNum, pageSize);
        // 每页的数据
        List<Pokemen> pokemen = pokemenService.findPokemensPage(qeVo);
        // 分页信息工具类
        PageInfo<Pokemen> pageInfo = new PageInfo<>(pokemen);

        // 存值到 model 容器中
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("qeVo", qeVo);
        return "pokemen";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model) {
        List<Attributes> attributes = pokemenService.findAttributes();
        model.addAttribute("attributes", attributes);
        return "add";
    }

    @RequestMapping("/doAdd")
    public String doAdd(Pokemen pokemen, Integer[] attrss, MultipartFile uploadFile,
                        HttpServletRequest request) throws IOException {
        // 接收文件
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        // File 形式
        File file = new File(realPath);
        // 判断 File 是否存在
        if (!file.exists()) {
            file.mkdir(); // 创建目录
        }
        // 解决命名冲突
        String oName = uploadFile.getOriginalFilename(); //获取文件的原名
        String nName = UUID.randomUUID().toString() + oName.substring(oName.indexOf("."));
        // 将本地传来的文件复制到 realPath
        // 复制
        File nfile = new File(realPath + "/" + nName);
        uploadFile.transferTo(nfile);
        // 新增
        pokemen.setUrl(nName);
        // 接收完成
        pokemenService.addPokemen(pokemen);
        int pid = pokemen.getId();
        Map<String,Object> map = new HashMap<>();
        map.put("pid",pid);
        map.put("attrss",attrss);
        int len = pokemenService.addPokemenAttrs(map);
        if (len > 0) {
            return "redirect:toPokemen.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("/preUpdata")
    public String preUpdata(Integer pid, Model model) {
        Pokemen pokemen = pokemenService.findPokemensById(pid);
        List<Attributes> attributes = pokemenService.findAttributes();

        List<Attributes> pattrs = pokemenService.findAttributesById(pid);
        pokemen.setAttrs(pattrs);

        model.addAttribute("pokemen", pokemen);
        model.addAttribute("attributes", attributes);
        return "updata";
    }

    @RequestMapping("/doUpdata")
    public String doUpdata(Pokemen pokemen, Integer[] attrss, MultipartFile uploadFile,
                           HttpServletRequest request) throws IOException {
        // 接收文件
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        // File 形式
        File file = new File(realPath);
        // 判断 File 是否存在
        if (!file.exists()) {
            file.mkdir(); // 创建目录
        }
        // 解决命名冲突
        String oName = uploadFile.getOriginalFilename(); //获取文件的原名
        String nName = UUID.randomUUID().toString() + oName.substring(oName.indexOf("."));
        // 将本地传来的文件复制到 realPath
        // 复制
        File nfile = new File(realPath + "/" + nName);
        uploadFile.transferTo(nfile);
        // 新增
        pokemen.setUrl(nName);
        // 接收完成
        int len = pokemenService.updatePokemen(pokemen);
        int pid = pokemen.getId();
        Map<String,Object> map = new HashMap<>();
        map.put("pid",pid);
        map.put("attrss",attrss);
        pokemenService.updatePokemenAttrs(map);
        if (len > 0) {
            return "redirect:toPokemen.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("delete")
    public String delete(Integer pid) {
        int len = pokemenService.deletePokemen(pid);
        if (len > 0) {
            return "redirect:toPokemen.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("toAtlas")
    public String toAtlas(){
        return "atlas";
    }

    @RequestMapping("doExport")
    public void doExport(HttpServletResponse response) throws IOException {
        //创建工作簿
        Workbook wb = new XSSFWorkbook();
        //创建sheet页
        Sheet sheet = wb.createSheet();
        //创建行
        Row row = sheet.createRow(0);
        //声明表格
        String[] header = {"序号","编号","名称","图片","身高","体重","战斗力","特点"};
        //循环行创建单元格
        for (int i = 0; i <header.length ; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(header[i]);
        }
        //从数据库查询所有记录
        List<Pokemen> list = pokemenService.findPokemens();
        for (int i = 0; i < list.size(); i++) {
            Pokemen pokemen = list.get(i);
            Row row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(pokemen.getId());
            row1.createCell(1).setCellValue(pokemen.getNumber());
            row1.createCell(2).setCellValue(pokemen.getName());
            row1.createCell(3).setCellValue(pokemen.getUrl());
            row1.createCell(4).setCellValue(pokemen.getStature());
            row1.createCell(5).setCellValue(pokemen.getWeight());
            row1.createCell(6).setCellValue(pokemen.getSs());
            row1.createCell(7).setCellValue(pokemen.getCharacteristic());
        }

        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("宝可梦列表.xlsx", "UTF-8"));
        response.setHeader("Connection", "close");
        response.setHeader("Content-Type", "application/octet-stream");
        wb.write(response.getOutputStream());
        wb.close();
    }

    @RequestMapping("toImport")
    public String toImport(){
        return "import";
    }

    @RequestMapping("doImport")
    public String doImport(MultipartFile importExcel) throws IOException {
        List<Pokemen> pokemens = new ArrayList<>();
        //获取工作簿
        Workbook wb = new XSSFWorkbook(importExcel.getInputStream());
        //获取sheet页
        Sheet sheet = wb.getSheetAt(0);
        //获取最后一行的行数
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <=lastRowNum ; i++){
            //获取行对象
            Row row = sheet.getRow(i);
            //获取单元格内的数据 "序号","编号","名称","图片","身高","体重","特点"
            Double numericCellValue = row.getCell(1).getNumericCellValue();
            Integer number = numericCellValue.intValue();
            String name = row.getCell(2).toString();
            String url = row.getCell(3).toString();
            String stature = row.getCell(4).toString();
            String weight = row.getCell(5).toString();
            Double ssCellValue = row.getCell(6).getNumericCellValue();
            Integer ss = ssCellValue.intValue();
            String characteristic = row.getCell(7).toString();
            // 封装为对象
            Pokemen pokemen = new Pokemen();
            pokemen.setNumber(number);
            pokemen.setName(name);
            pokemen.setUrl(url);
            pokemen.setStature(stature);
            pokemen.setWeight(weight);
            pokemen.setSs(ss);
            pokemen.setCharacteristic(characteristic);
            // 加入对象数组
            pokemens.add(pokemen);
        }
        int len = pokemenService.addPokemens(pokemens);
        if (len > 0) {
            return "redirect:toPokemen.do";
        } else {
            return "error";
        }
    }
}
