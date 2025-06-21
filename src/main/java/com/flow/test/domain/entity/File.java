package com.flow.test.domain.entity;

import com.flow.test.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String extension;

    @Column(name = "is_fixed", nullable = false)
    private boolean isFixed;

    @Column(name = "is_blocked", nullable = false)
    private boolean isBlocked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder(access = AccessLevel.PRIVATE)
    private File(String extension, boolean isFixed, boolean isBlocked, Post post) {
        this.extension = extension;
        this.isFixed = isFixed;
        this.isBlocked = isBlocked;
        this.post = post;
    }

    public static File create(String extension, boolean isFixed, boolean isBlocked, Post post) {
        return File.builder()
                .extension(extension)
                .isFixed(isFixed)
                .isBlocked(isBlocked)
                .post(post)
                .build();
    }


}
