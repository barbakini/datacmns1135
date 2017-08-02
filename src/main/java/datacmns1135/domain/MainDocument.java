package datacmns1135.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by barbakini on 3.03.2017.
 */

@Document
@Data
public class MainDocument {

    private String _id;

    private InfoContainer<UpperInfo> upperInfoContainer;
}
