package datacmns1135.domain;

import lombok.Data;

/**
 * Created by barbakini on 7.03.2017.
 */
@Data
public class UpperInfo extends Info {

    private InfoContainer<SubInfo> subInfos;

}
