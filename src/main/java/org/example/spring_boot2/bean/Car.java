package org.example.spring_boot2.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lifei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;
}
