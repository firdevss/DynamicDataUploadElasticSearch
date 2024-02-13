package com.siber.project.controller;

import com.siber.project.dto.ResultVm;
import com.siber.project.dto.TextFileDto;
import com.siber.project.entity.Password;
import com.siber.project.service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/test/")
@AllArgsConstructor
public class PasswordController {
    final PasswordService passwordService;

/*    @GetMapping("testing")
    public String Test() throws IOException {
        return passwordService.Test();
    }*/

    @GetMapping("getAllPasswords/{indexName}")
    public List<Password> getAllPasswords(@PathVariable String indexName) {
        return passwordService.getAllPasswords(indexName);
    }

    @PostMapping("addPassword")
    public String AddPassword() {
        return passwordService.addPassword();
    }

    @PostMapping("addTextFile")
    public ResponseEntity<ResultVm> addTextFile(@ModelAttribute TextFileDto textFileDto) {
        ResultVm vm = new ResultVm();
        try {
            vm.setResultSet(passwordService.addTextFile(textFileDto));
            vm.addMessage("İşlem Başarılı");
            vm.setIsSuccess(true);
        } catch (Exception e) {
            vm.addMessage(e.getMessage());
        }
        return ResponseEntity.accepted().body(vm);
    }

}
