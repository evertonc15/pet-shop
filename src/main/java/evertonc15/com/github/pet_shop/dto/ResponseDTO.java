package evertonc15.com.github.pet_shop.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO {

    private String message;
    private Integer statusHttp;

}
