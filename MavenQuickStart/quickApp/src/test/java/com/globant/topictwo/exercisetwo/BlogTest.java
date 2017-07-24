package com.globant.topictwo.exercisetwo;

import java.util.Date;
import java.util.LinkedList;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Class container of test battery for My blog app.
 * 
 * @author andres.vaninetti
 *
 */
public class BlogTest {

	@Test
	public final void WhenPostNewEntryThenIncludeThisInTheBlog() {
		Blog myBlog = new Blog("Boca Juniors", "Vaninetti, Andrés", "Default", new LinkedList<Entry>());
		Entry myEntry = new Entry("Boca Juniors the new champion", "Sports", "Boca juntios campeon del mundo", new Date());
		myBlog.post(myEntry);
		Assert.assertFalse("The list haven't entries", myBlog.getEntries().isEmpty());
	}

	@Test
	public final void DeleteNewEntryFromBlogTest() {
		Blog myBlog = new Blog("Boca Juniors", "Vaninetti, Andrés", "Default", new LinkedList<Entry>());
		Entry bocaJuniors = new Entry("Boca Juniors the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		myBlog.post(bocaJuniors);
		myBlog.deleteEntry(bocaJuniors);
		Assert.assertTrue(myBlog.getEntries().isEmpty());
	}

	@Test
	public final void WhenListThePostsThenShowsTheLastTen() {
		Blog myBlog = new Blog("Boca Juniors", "Vaninetti, Andrés", "Default", new LinkedList<Entry>());
		Entry bocaJuniors = new Entry("Boca Juniors the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry riverPlate = new Entry("River Plate the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry independiente = new Entry("Independiente the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry racing = new Entry("Racing the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry sanLorenzo = new Entry("San Lorenzo the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry newells = new Entry("Newells the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry rosarioCentral = new Entry("Rosario Central the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry banfield = new Entry("Banfield the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry velez = new Entry("Velez the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry argentinosJuniors = new Entry("Argentinos Juniors the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		Entry gimnasiaLp = new Entry("Gimnasia de la Plata the new champion", "Sports", "Boca juniors campeon del mundo", new Date());
		myBlog.post(gimnasiaLp);
		myBlog.post(argentinosJuniors);
		myBlog.post(velez);
		myBlog.post(banfield);
		myBlog.post(rosarioCentral);
		myBlog.post(newells);
		myBlog.post(sanLorenzo);
		myBlog.post(racing);
		myBlog.post(independiente);
		myBlog.post(riverPlate);
		myBlog.post(bocaJuniors);
		myBlog.showEntries();
	}
}
