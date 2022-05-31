package app.dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private Integer b_id;

    private int type;

    private String title;

    private String contents;

    private Integer memberNo;

    private Integer b_like;

    private Integer b_view;
}