package suite.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.Pdp_BMG_Page;
import suite.testdata.Pdp_BMG_TestData;



public class Pdp_BMG_Test extends TestBase {

	private Pdp_BMG_Page pdp;

	private String getPageUrl() {
		return getEnv().concat(Pdp_BMG_TestData.PDP_PAGE);
	}

	private String getPageUrlInstantRebate() {
		return getEnv().concat(Pdp_BMG_TestData.INSTANT_REBATE_PAGE);
	}

	private String getAddToCartPageUrl() {
		return getEnv().concat(Pdp_BMG_TestData.ADD_TO_CART_PAGE);
	}

	@Test(enabled = false, description = "Verify that the product is added to mini cart", 
			groups = { "done", "pdp_bmg" })

	public void pdp_bmg_1() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getAddToCartPageUrl()).clkAddtoCartBtn();

		String actual = pdp.getProductNameAddToMiniCart();

		Assert.assertEquals(actual, Pdp_BMG_TestData.PRODUCT_NAME_ADDED_TO_MINI_CART);

	}

	@Test(enabled = false,description = "Verify that the popup gets generated when the user clicks on where to buy option",
			groups = {"done", "pdp_bmg" })

	public void pdp_bmg_2() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkwhereToBuyBtn();

		String actual = pdp.getWhereToBuyPopUp();

		Assert.assertEquals(actual, Pdp_BMG_TestData.EXPECTED_TITLE_WHERE_TO_BUY_POPUP);

	}

	@Test(enabled = false,description = "Verify the text present under the about product section",
			groups = { "done", "pdp_bmg" })

	public void pdp_bmg_3() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkAboutProductSection();

		String actual = pdp.getAboutTheProdTxt();

		Assert.assertEquals(actual, Pdp_BMG_TestData.ABOUT_THE_PROD_TXT);

	}

	@Test(enabled = true,description = "verify the text present under specification section",
			groups = { "done", "pdp_bmg" })

	public void pdp_bmg_4() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkAboutProductSpecification();

		String actual = pdp.isBasicFeatureDisplayed();

		Assert.assertEquals(actual, Pdp_BMG_TestData.EXPECTED_PROD_SPECIFICATION_EXPAND);

	}


	@Test(enabled=false,description = "Verify the specified product name under supplies and accessories tab",
			groups = {"done","pdp_bmg" })

	public void pdp_bmg_5() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkSuppliesAccessoriesTab();

		String actual = pdp.getFirstDisplayedAccName();

		Assert.assertEquals(actual, Pdp_BMG_TestData.FIRST_DISPLAYED_ACC_NAME);

	}

	@Test(enabled = false,description = "Verify on clicking on add to cart button under supplies and accessories tab, selected item is displayed in mini cart", 
			groups = {"wip", "pdp_bmg" })
	
	public void pdp_bmg_6(){
		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl())
		.clkSuppliesAccessoriesTab()
		.clkAddToCartASBtn();
		System.out.println("Supply and acce successfully added to mini cart");
	}
}
