package com.siber.project.service;

import com.siber.project.component.IndexNameProvider;
import com.siber.project.dao.PasswordRepository;
import com.siber.project.dto.TextFileDto;
import com.siber.project.entity.Password;
import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.NoSuchIndexException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class PasswordService {

    final PasswordRepository passwordRepository;
    final IndexNameProvider indexNameProvider;

    public String addPassword() {
        indexNameProvider.setIndexName("fir");

        Password password = new Password();
        password.setName("of");
        passwordRepository.save(password);

        return "Kayıt Başarılı.";
    }

    public List<Password> getAllPasswords(String indexName) {
        indexNameProvider.setIndexName(indexName);

        try {
            Iterable<Password> iterable = passwordRepository.findAll();
            ArrayList<Password> list = StreamSupport.stream(iterable.spliterator(), false)
                    .collect(Collectors.toCollection(ArrayList::new));
            return list;
        } catch (NoSuchIndexException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public String addTextFile(TextFileDto textFileDto) throws IOException {
        indexNameProvider.setIndexName(textFileDto.getIndexName());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(textFileDto.getFile().getInputStream()));

        String line = bufferedReader.readLine();
        if (line == null) throw new RuntimeException("Dosyanın İçi Boş.");
        do {
            List<Password> strList = new ArrayList<>();
            while (line != null) {
                /* if (passwordRepository.findByName(line).isEmpty()) {*/
                if (!line.equals("")) {
                    Password password = new Password();
                    password.setName(line);
                    strList.add(password);
                }
                line = bufferedReader.readLine();
                if (strList.size() >= 100000) break;
            }
            passwordRepository.saveAll(strList);

        } while (line != null);

        return "İşlem Başarılı";
    }

}
