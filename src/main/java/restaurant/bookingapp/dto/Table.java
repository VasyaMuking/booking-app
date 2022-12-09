package restaurant.bookingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.bookingapp.model.TableStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Table {
    private Integer id;
    private TableStatus tableStatus; //TODO подумать нужен ли он вообще, и стоить ли добавить параметры стола для резервирования.
}
