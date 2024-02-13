package com.siber.project.controller;/*
package com.siber.project.controller;

import com.siber.project.dto.ResultVm;
import com.siber.project.entity.IndexName;
import com.siber.project.service.IndexNameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/indexName/")
@AllArgsConstructor
public class IndexNameController {
    final IndexNameService indexNameService;

    @GetMapping("getAllIndexName")
    public ResponseEntity<ResultVm> getAllIndexName() {
        ResultVm vm = new ResultVm();
        try {
            vm.setResultSet(indexNameService.getAllIndexName());
            vm.setIsSuccess(true);
            vm.addMessage("İşlem Başarılı");
        } catch (Exception e) {

            vm.addMessage(e.getMessage());
        }
        return ResponseEntity.accepted().body(vm);
    }

    @GetMapping("getIndexNameById/{id}")
    public ResponseEntity<ResultVm> getIndexNameById(@PathVariable Long id) {
        ResultVm vm = new ResultVm();
        try {
            vm.setResultSet(indexNameService.getIndexNameById(id));
            vm.setIsSuccess(true);
            vm.addMessage("İşlem Başarılı");
        } catch (Exception e) {

            vm.addMessage(e.getMessage());
        }
        return ResponseEntity.accepted().body(vm);
    }

    @PostMapping("saveIndexName")
    public ResponseEntity<ResultVm> saveIndexName(@RequestBody IndexName indexName) {
        ResultVm vm = new ResultVm();
        try {
            vm.setResultSet(indexNameService.saveIndexName(indexName));
            vm.addMessage("İşlem Başarılı");
            vm.setIsSuccess(true);
        } catch (Exception e) {
            vm.addMessage(e.getMessage());
        }
        return ResponseEntity.accepted().body(vm);
    }

    @GetMapping("deleteIndexName/{id}")
    public ResponseEntity<ResultVm> deleteIndexName(@PathVariable Long id) {
        ResultVm vm = new ResultVm();
        try {
            vm.setResultSet(indexNameService.deleteIndexName(id));
            vm.setIsSuccess(true);
            vm.addMessage("İşlem Başarılı");
        } catch (Exception e) {

            vm.addMessage(e.getMessage());
        }
        return ResponseEntity.accepted().body(vm);
    }
}
*/
