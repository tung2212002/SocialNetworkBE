package com.tungong.socialnetwork.infrastructure.payload.request;

import com.tungong.socialnetwork.common.customAnnotation.constraint.PatternConstraint;
import com.tungong.socialnetwork.common.customAnnotation.enums.EPatternValidator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaginationRequest {
    @Min(value = 0, message = "Page number must be greater than 0")
    @Max(value = 100, message = "Page number must be less than 100")
    Integer page;

    @Min(value = 1, message = "Page size must be greater than 0")
    @Max(value = 1000, message = "Page size must be less than 1000")
    Integer size;

    @PatternConstraint(EPatternValidator.ORDER_BY)
    String orderBy = "createdAt";

    @PatternConstraint(EPatternValidator.SORT_BY)
    String sortBy = "desc";

    public Pageable getPageable() {
        return PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortBy), orderBy));
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page, size, sort);
    }

    public Pageable getPageable(Sort.Direction direction) {
        return PageRequest.of(page, size, Sort.by(direction, orderBy));
    }

    public Pageable getPageableNative() {
        if (sortBy.equals("createdAt")) {
            sortBy = "created_at";
        }
        if (sortBy.equals("updatedAt")) {
            sortBy = "updated_at";
        }
        return PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(orderBy), sortBy));
    }

    public Pageable getPageable(Sort.Direction direction, String orderBy) {
        return PageRequest.of(page, size, Sort.by(direction, orderBy));
    }

    public Pageable getPageableNotSort() {
        return PageRequest.of(page, size);
    }
}
