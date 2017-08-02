package datacmns1135;

import datacmns1135.domain.InfoContainer;
import datacmns1135.domain.MainDocument;
import datacmns1135.domain.SubInfo;
import datacmns1135.domain.UpperInfo;
import datacmns1135.repository.MainDocumentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(SpringRunner.class)
@DataMongoTest
public class Datamongo1763ApplicationTests {

	@Autowired
	MainDocumentRepository repository;

	private MainDocument getMainDocument() {
		MainDocument mainDocument = new MainDocument();
		mainDocument.set_id("mainDocumentId");
		InfoContainer<UpperInfo> upperContainer = new InfoContainer<>();
		upperContainer.set_id("upperContainer");
		upperContainer.setSomeField("I am UpperInfo Container");
		upperContainer.getValues().add(new UpperInfo());
		upperContainer.getValues().get(0).set_id("upperInfoId");
		InfoContainer<SubInfo> subContainer = new InfoContainer<>();
		subContainer.set_id("subContainer");
		subContainer.setSomeField("I am SubInfo Container");
		subContainer.getValues().add(new SubInfo());
		subContainer.getValues().get(0).set_id("subInfoId");
		upperContainer.getValues().get(0).setSubInfos(subContainer);
		mainDocument.setUpperInfoContainer(upperContainer);
		return mainDocument;
	}

	@Test
	public void repositoryReadsShouldCastGenericSubDocumentsCorrectly() {
		repository.deleteAll();
		repository.save(getMainDocument());
		MainDocument mainDocument = repository.findOne(getMainDocument().get_id());

		Assert.assertThat(mainDocument, instanceOf(MainDocument.class));
		Assert.assertThat(mainDocument.getUpperInfoContainer().getValues().get(0), instanceOf(UpperInfo.class));
		Assert.assertThat(mainDocument.getUpperInfoContainer().getValues().get(0).getSubInfos().getValues().get(0), instanceOf(SubInfo.class));

	}

}
