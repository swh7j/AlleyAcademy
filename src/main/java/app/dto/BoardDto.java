package app.dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int boardNo;
    private String boardTitle;
    private String boardContents;
    private String boardWriter;
    private String boardView;
}