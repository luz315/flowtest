package com.flow.test.application;

import com.flow.test.domain.entity.File;
import com.flow.test.domain.entity.FileType;
import com.flow.test.domain.entity.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class FileService {

    public List<File> createFiles(Post post, List<String> uploadedExtensions, List<String> checkedTypes) {
        Set<String> fixedTypes = checkedTypes.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        Set<String> uploaded = uploadedExtensions.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        Set<String> total = new HashSet<>();
        total.addAll(fixedTypes);
        total.addAll(uploaded);

        if (total.isEmpty()) {
            throw new IllegalArgumentException("최소 하나 이상의 확장자를 선택하거나 입력해야 합니다.");
        }

        if (total.size() != fixedTypes.size() + uploaded.size()) {
            throw new IllegalArgumentException("중복된 확장자가 존재합니다.");
        }

        log.info("전체 입력 확장자: {}", total);

        return total.stream()
                .map(ext -> {
                    boolean isFixed = fixedTypes.contains(ext); // 실제 선택된 고정 확장자에 기반
                    return File.create(ext, isFixed, false, post);
                })
                .toList();
    }

}
