package datacmns1135.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by barbakini on 3.03.2017.
 */
@Data
public class InfoContainer<E extends Info> {

    private String _id;

    private String someField;

    private List<E> values = new ArrayList<>();

}
