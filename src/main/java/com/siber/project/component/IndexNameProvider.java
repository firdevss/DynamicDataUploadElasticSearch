package com.siber.project.component;

import org.springframework.stereotype.Component;

@Component("esConfig")
public class IndexNameProvider {
    private String indexName;

    public String getIndexName() {
        if (indexName == null) return "xyz";
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String timeSuffix() {
        return "testing...";
    }
}
