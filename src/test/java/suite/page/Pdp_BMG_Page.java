package suite.page;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class Pdp_BMG_Page extends PageBase {

	public Pdp_BMG_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;

	@FindBy(css = ".btn.janus-where-to-buy-btn.btn-md.m-b-15 > div span")
	private List<WebElement> whereToASBuyBtn;

	@FindBy(css = ".component.cxa-product-kit-component > h2")
	private WebElement supplySection;

	@FindBy(css = "#sitecoreId")
	private WebElement crossIcon;

	@FindBy(css = ".submit > a")
	private WebElement acceptCookiesBtn;

	@FindBy(css = ".janus-pdp-pric-section:nth-child(1) form")
	private WebElement AddToCartBtn;

	@FindBy(css = "a > h5")
	private WebElement pdpProductName;

	@FindBy(linkText = "PriceSpider Terms of Service")
	private WebElement whereToBuyPopUpBottom;

	@FindBy(css = "a.btn-lg > div.ps-enabled.ps-widget")
	private WebElement whereToBuyBtn;

	@FindBy(css = ".active > .janus-scroll-trigger")
	private WebElement aboutThePageSection;

	@FindBy(css = "h2.m-b-30")
	private WebElement aboutTheProdText;

	@FindBy(css = "li:nth-child(5) > .janus-scroll-trigger")
	private WebElement prodReviewBtn;

	@FindBy(css = "li:nth-child(2) > .janus-scroll-trigger")
	private WebElement prodSpecification;

	@FindBy(css = "li:nth-child(2) > .janus-scroll-trigger")
	private WebElement prodSpecificationTxt;

	@FindBy(css = "#accordion > .panel:nth-child(1) a")
	private WebElement basicFeatureDropDown;

	@FindBy(css = "#bv-text-field-search-contentSearch1")
	private WebElement prodReviewSearchBox;

	@FindBy(css = ".bv-search-control-icon:nth-child(1)")
	private WebElement reviewSearchbtn;

	@FindBy(css = ".bv-content-search-results")
	private WebElement productReviewPopUp;

	@FindBy(css = "#supportIcon .img-responsive")
	private WebElement contactUsBtn;

	@FindBy(css = ".modal-body .janus-btn-blue")
	private WebElement emailSupportBtn;

	@FindBy(css = "#rn_PageTitle > h1")
	private WebElement emailSupportPageTitle;

	@FindBy(css = ".support-link > a")
	private WebElement supportTab;

	@FindBy(css = ".janus-s-p-titles > a")
	private WebElement supportPageTitleTxt;

	@FindBy(css = "li:nth-child(3) > .janus-scroll-trigger")
	private WebElement suppliesAccessoriesBtn;

	@FindBy(css = ".janus-pdp-supplies-card:nth-child(1) h2")
	private WebElement firstDisplayedAccName;

	@FindBy(css = ".ps-product-details-title")
	private WebElement locateDealerPageTitle;

	@FindBy(css = ".janus-pdp-supplies-card:nth-child(1) form")
	private WebElement addToCartASBtn;

	@FindBy(css = "#janus-minicart2 > div > div.minicart.dropdown-menu > div > div.minicart2 > div > div:nth-child(2) > div > div.janus-shop-c-col-description > div > a > h5")
	private WebElement selectedProdNameMiniCart;

	@FindBy(css = ".btn-lg:nth-child(8)")
	private WebElement addToCartInStockBtn;

	@FindBy(linkText = "Computerized Sewing and Embroidery Machine with 4\" x 4\" Embroidery Area")
	private WebElement productNameInMiniCart;

	@FindBy(css = ".checkout-button")
	private WebElement clkProceedToCartBtn;

	@FindBy(css = ".janus-pdp-supplies-card:nth-child(1) .add-to-cart-btn")
	private WebElement clkAccessory1Btn;

	@FindBy(css = ".janus-pdp-supplies-card:nth-child(2) .add-to-cart-btn")
	private WebElement clkAccessory2Btn;

	@FindBy(css = ".hidden-sm-:nth-child(1)")
	private WebElement clkContinueToShopBtn;

	@FindBy(css = ".form-control")
	private WebElement applyPromoCodeTxtBox;

	@FindBy(css = ".janus-apply-btn")
	private WebElement clkApplyBtn;

	@FindBy(css = ".janus-cart-count")
	private WebElement noOfProductsAddedToMiniCart;

	@FindBy(css = "b > span")
	private WebElement productCostAfterSavings;

	@FindBy(css = ".janus-cart-count")
	private WebElement clkMiniCart;

	@FindBy(css = ".m-r-10")
	private WebElement ShoppingCartPageContinueToShopBtn;

	@FindBy(css = ".j-instant-reb-text")
	private WebElement instantRebateTxt;

	@FindBy(css = "#wc-features-3b68dc2a > h2")
	private WebElement aPlusWebContent;



	public Pdp_BMG_Page getPdpPage(String pageURL) {
		NavigatetoPage(pageURL);
		//clickingElement(crossIcon);
		clickingElement(acceptCookiesBtn);
		return this;
	}

	public String getProductNameAddToMiniCart() {
		return getText(pdpProductName);
	}

	/**
	 * For clicking on add to cart button on pdp
	 * 
	 * @return object of current class
	 */

	public Pdp_BMG_Page clkAddtoCartBtn() {
		clickingElementAction(AddToCartBtn);
		return this;
	}

	/**
	 * For clicking the where to buy button of the pdp page.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkwhereToBuyBtn() {
		for (int i = 0; i < 2; i++) {
			clickingElementJS(whereToBuyBtn);
			try {
				if (getWebElement(whereToBuyPopUpBottom).isDisplayed())
					return this;
			} catch (TimeoutException | NoSuchElementException e) {

				clickingElementJS(whereToBuyBtn);
				break;
			}
		}
		return this;
	}

	/**
	 * for getting price spider logo from where to buy pop up
	 * 
	 * @return product name from where to buy pop up
	 */
	public String getWhereToBuyPopUp() {
		return getText(whereToBuyPopUpBottom);
	}

	/**
	 * For clicking the product specification specfication tab
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkAboutProductSpecification() {
		clickingElement(prodSpecification);
		return this;

	}

	/**
	 * For clicking the about product section of the pdp page
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkAboutProductSection() {
		clickingElement(aboutThePageSection);
		return this;
	}

	/**
	 * For getting the about the product section text
	 * 
	 * @return text displayed inside about the section
	 */

	public String getAboutTheProdTxt() {
		return getText(aboutTheProdText);

	}

	/**
	 * For getting attribute value of the basic feature section under about the
	 * product tab.
	 * 
	 * @return the attribute of the basic feature dropdown.
	 */

	public String isBasicFeatureDisplayed() {
		return getAttributeValue(basicFeatureDropDown, "aria-expanded");
	}

	/**
	 * For clicking on the Supplies and Accessories tab.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkSuppliesAccessoriesTab() {
		clickingElement(suppliesAccessoriesBtn);
		return this;
	}

	/**
	 * For getting the first displayed accessory name under the supplies and
	 * accessories tab.
	 * 
	 * @return the object of the current class.
	 */

	public String getFirstDisplayedAccName() {
		return getText(firstDisplayedAccName);
	}

	/**
	 * For getting support page title text.
	 * 
	 * @return the text displayed under support page
	 */

	public Pdp_BMG_Page clkAddToCartASBtn() {
		scrollTo(supplySection);
		clickingElement(addToCartASBtn);
		return this;
	}

	/**
	 * For getting selected product name.
	 * 
	 * @return the text of the selected product.
	 */

	public String getSelectedProductName() {
		return getText(selectedProdNameMiniCart);
	}


}