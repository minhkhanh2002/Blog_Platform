package com.kanen.blog.mappers;

import com.kanen.blog.domain.PostStatus;
import com.kanen.blog.domain.dtos.CategoryDto;
import com.kanen.blog.domain.dtos.CreateCategoryRequest;
import com.kanen.blog.domain.entities.Category;
import com.kanen.blog.domain.entities.Post;
import com.kanen.blog.repositories.CategoryRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity( CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts){
        if (null == posts){
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}