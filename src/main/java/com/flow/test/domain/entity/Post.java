package com.flow.test.domain.entity;

import com.flow.test.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> fileList = new ArrayList<>();

    @Column
    private boolean status;

    @Builder(access = AccessLevel.PRIVATE)
    private Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Post create(String title, String content) {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }

    public void delete() {
        this.status = true;
        markDeletedAt();
    }

    public void addFile(List<File> files) {
        this.fileList.addAll(files);
    }
}
