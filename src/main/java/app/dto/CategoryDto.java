package app.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private int categoryNo;
    private int type;
}