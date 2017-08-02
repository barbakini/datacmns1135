package datacmns1135.repository;

import datacmns1135.domain.MainDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by barbakini on 3.03.2017.
 */
@Repository
public interface MainDocumentRepository extends MongoRepository<MainDocument, String> {
}
