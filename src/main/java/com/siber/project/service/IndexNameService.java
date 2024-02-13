package com.siber.project.service;/*
package com.siber.project.service;

import com.siber.project.dao.IndexNameRepository;
import com.siber.project.entity.IndexName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IndexNameService {
    final IndexNameRepository indexNameRepository;

    public List<IndexName> getAllIndexName() {
        return indexNameRepository.findAll();
    }

    public String getIndexNameById(Long id) {
        return String.valueOf(indexNameRepository.findById(id));
    }

    public IndexName saveIndexName(IndexName indexName) {
        if(indexName == null) throw new RuntimeException("Index Adı Boş olamaz!");
        if(indexNameRepository.findByName(indexName.getName()).size() > 0)
           throw new RuntimeException("Aynı İsimde Bir Index Var!");
        IndexName save = (IndexName) indexNameRepository.save(indexName);
        return save;
    }

    public String deleteIndexName(Long id){
        indexNameRepository.deleteById(id);
        return "İşlemBaşarılı";
    }

}
*/
