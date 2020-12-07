package suite.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.CheckoutPage;
import suite.testdata.CheckoutTestData;

//@Listeners(ExecutionListener.class)
	public class CheckoutTest extends TestBase {

		
		  private XSSFSheet getSheet() { return getTestData().getSheet("Guest_user"); }
		
		  private CheckoutPage co;
			DataFormatter formatter = new DataFormatter();
			private Cell cell;

			private String getPageUrl() {
				return getEnv().concat((getSheet().getRow(1).getCell(1).getStringCellValue()));
				
									
			}
			
			private String getLoginPageUrl() {
				return getEnv().concat(CheckoutTestData.LOGIN_PAGE);
			}
			
			private String getCardNo() {
				 cell= getSheet().getRow(1).getCell(13);
				 return formatter.formatCellValue(cell);
									
			}
			
			private String getCardNo2() {
				 cell= getSheet().getRow(2).getCell(13);
				 return formatter.formatCellValue(cell);
									
			}
			
			private String getCardNo3() {
				 cell= getSheet().getRow(3).getCell(13);
				 return formatter.formatCellValue(cell);
									
			}
			
			private String getCardNo4() {
				 cell= getSheet().getRow(4).getCell(13);
				 return formatter.formatCellValue(cell);
									
			}
			
			private String getPhoneNo() {
				 cell= getSheet().getRow(2).getCell(5);
				 return formatter.formatCellValue(cell);						
			}
			
			private String getZipCode() {
				 cell= getSheet().getRow(1).getCell(9);
				 return formatter.formatCellValue(cell);						
			}
			
			private String getEXDateMM() {
				 cell= getSheet().getRow(1).getCell(14);
				 return formatter.formatCellValue(cell);						
			}
			
			private String getEXDateYY() {
				 cell= getSheet().getRow(1).getCell(15);
				 return formatter.formatCellValue(cell);						
			}
			
			private String getCVV() {
				 cell= getSheet().getRow(1).getCell(16);
				 return formatter.formatCellValue(cell);						
			}
	    
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user with visa credit card", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_1() {
			
			  co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(1).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(1).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(1).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(1).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(1).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(1).getCell(11).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE) 
			  .enterCardNoCc(getCardNo())
			  .enterExpiryMmCc(getEXDateMM()) 
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV()) 
			  .switchToPaymentPage() .clkConfirmBtn()
			  .clkPlaceOrderBtn(); 
			  System.out.println("Thank you for shopping with us!");
				 
		
				
		}
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user with master credit card", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_2() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(2).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(2).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(2).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(2).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(2).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(2).getCell(11).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_MASTER)
			  .enterCardNoCc(getCardNo2())
			  .enterExpiryMmCc(getEXDateMM())
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV())
			  .switchToPaymentPage()
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn();
			System.out.println("Thank you for shopping with us!");
		
				
		}
		@Test(enabled=true,description = "Checkout-Placed order using guest user with Amex credit card", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_3() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(3).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(3).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(3).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(3).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(3).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(3).getCell(10).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_AMEX)
			  .enterCardNoCc(getCardNo3())
			  .enterExpiryMmCc(getEXDateMM())
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV())
			  .switchToPaymentPage()
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn();
			System.out.println("Thank you for shopping with us!");
		
				
		}
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user with Discover credit card", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_4() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(4).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(4).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(4).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(4).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(4).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(4).getCell(10).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_DISC)
			  .enterCardNoCc(getCardNo4())
			  .enterExpiryMmCc(getEXDateMM())
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV())
			  .switchToPaymentPage()
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn();
			System.out.println("Thank you for shopping with us!");
		
				
		}
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user using Visa credit card with second day shipping", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_5() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(1).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(1).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(1).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(1).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(1).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkSecondDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(1).getCell(11).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE) 
			  .enterCardNoCc(getCardNo())
			  .enterExpiryMmCc(getEXDateMM()) 
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV()) 
			  .switchToPaymentPage() .clkConfirmBtn()
			  .clkPlaceOrderBtn(); 
			  System.out.println("Thank you for shopping with us!");
	}
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user using Master credit card with second day shipping", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_6() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(2).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(2).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(2).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(2).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(2).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkSecondDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(2).getCell(10).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_MASTER)
			  .enterCardNoCc(getCardNo2())
			  .enterExpiryMmCc(getEXDateMM())
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV())
			  .switchToPaymentPage()
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn();
			System.out.println("Thank you for shopping with us!");
	  
		}
			
		@Test(enabled=true,description = "Checkout-Placed order using guest user using Amex credit card with second day shipping", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_7() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(3).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(3).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(3).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(3).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(3).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkSecondDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(3).getCell(10).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_AMEX)
			  .enterCardNoCc(getCardNo3())
			  .enterExpiryMmCc(getEXDateMM())
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV())
			  .switchToPaymentPage()
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn();
			System.out.println("Thank you for shopping with us!");
			
		}
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user using Discover credit card with second day shipping", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_8() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(4).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(4).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(4).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(4).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(4).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkSecondDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(4).getCell(10).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_DISC)
			  .enterCardNoCc(getCardNo4())
			  .enterExpiryMmCc(getEXDateMM())
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV())
			  .switchToPaymentPage()
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn();
			System.out.println("Thank you for shopping with us!");
		
	}
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user using Discover credit card with next day shipping", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_9() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(1).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(1).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(1).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(1).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(1).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkNextDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(1).getCell(11).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE) 
			  .enterCardNoCc(getCardNo())
			  .enterExpiryMmCc(getEXDateMM()) 
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV()) 
			  .switchToPaymentPage() 
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn(); 
			  System.out.println("Thank you for shopping with us!");
	}
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user using Discover credit card with next day shipping", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_10() {
			
			  co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(2).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(2).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(2).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(2).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(2).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn() 
			  .clkNextDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(2).getCell(11).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_MASTER)
			  .enterCardNoCc(getCardNo2())
			  .enterExpiryMmCc(getEXDateMM())
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV())
			  .switchToPaymentPage()
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn();
			System.out.println("Thank you for shopping with us!");
	}
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user using Amex credit card with next day shipping", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_11() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(1).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(1).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(1).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(1).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(1).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn()
			  .clkNextDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(3).getCell(11).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_AMEX)
			  .enterCardNoCc(getCardNo3())
			  .enterExpiryMmCc(getEXDateMM()) 
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV()) 
			  .switchToPaymentPage() 
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn(); 
			  System.out.println("Thank you for shopping with us!");
	}
		
		
		@Test(enabled=true,description = "Checkout-Placed order using guest user using Discover credit card with next day shipping", groups = {"closed","checkout" })//need to be more than 2 items cent value problem
		public void co_12() {
			
			co = new CheckoutPage(getDriver()); 
			  co.getPdpCheckoutPage(getPageUrl())
			  .clkAddtoCartBtn() 
			  .clkProceedToCartBtn() 
			  .clkCheckoutBtn()
			  .clkCheckoutGuestBtn()
			  .enterGuestFname(getSheet().getRow(1).getCell(2).getStringCellValue())
			  .enterGuestLname(getSheet().getRow(1).getCell(3).getStringCellValue())
			  .enterGuestEmail(getSheet().getRow(1).getCell(4).getStringCellValue())
			  .enterGuestPhoneNo(getPhoneNo())
			  .enterGuestAddress(getSheet().getRow(1).getCell(6).getStringCellValue())
			  .enterGuestCity(getSheet().getRow(1).getCell(7).getStringCellValue())
			  .selectGuestState(CheckoutTestData.STATE)
			  .enterGuestZip(getZipCode())
			  .clkInfoNextBtn()
			  .clkNextDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheet().getRow(4).getCell(11).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_DISC)
			  .enterCardNoCc(getCardNo4())
			  .enterExpiryMmCc(getEXDateMM()) 
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV()) 
			  .switchToPaymentPage() 
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn(); 
			  System.out.println("Thank you for shopping with us!");
	}
	}