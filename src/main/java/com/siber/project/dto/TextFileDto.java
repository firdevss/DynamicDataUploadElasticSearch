package com.siber.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextFileDto {
    private Long indexId;
    private String indexName;
    private MultipartFile file;
}
