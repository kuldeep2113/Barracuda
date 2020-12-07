package suite.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.CheckoutPage;
import suite.testdata.CheckoutTestData;
import suite.utils.Xls_Reader;

//@Listeners(ExecutionListener.class)
	public class RegisteredCheckoutTest extends TestBase {

		private CheckoutPage co;
		DataFormatter formatter = new DataFormatter();
		private Cell cell;

		Xls_Reader reader = new Xls_Reader("src/main/resources/TestDataSheet.xlsx");
		
		private XSSFSheet getSheetS1() { 
			 return getTestData().getSheet("Registered_user"); 
			 }
		
		private String getPageUrlStandard() {
			return getEnv().concat((getSheetS().getRow(1).getCell(3).getStringCellValue()));
		}
		
		private String getPageUrlSecond() {
			return getEnv().concat((getSheetS().getRow(6).getCell(3).getStringCellValue()));
		}
		
		private String getPageUrlNext() {
			return getEnv().concat((getSheetS().getRow(10).getCell(3).getStringCellValue()));
		}
		
		private String getLoginPageUrl() {
			return getEnv().concat(CheckoutTestData.LOGIN_PAGE);
		}
		
		private String getCardNo() {
			 cell= getSheetS1().getRow(1).getCell(11);
			 return formatter.formatCellValue(cell);
								
		}
		
				
		private String getCardNo2() {
			 cell= getSheetS1().getRow(2).getCell(11);
			 return formatter.formatCellValue(cell);
								
		}
		
		private String getCardNo3() {
			 cell= getSheetS1().getRow(4).getCell(11);
			 return formatter.formatCellValue(cell);
								
		}
		
		private String getCardNo4() {
			 cell= getSheetS1().getRow(5).getCell(11);
			 return formatter.formatCellValue(cell);
								
		}
		
			
		private String getPhoneNo() {
			 cell= getSheetS1().getRow(2).getCell(4);
			 return formatter.formatCellValue(cell);						
		}
		
		private String getZipCode() {
			 cell= getSheetS1().getRow(2).getCell(8);
			 return formatter.formatCellValue(cell);						
		}
		
		private String getEXDateMM() {
			 cell= getSheetS1().getRow(2).getCell(12);
			 return formatter.formatCellValue(cell);						
		}
		
		private String getEXDateYY() {
			 cell= getSheetS1().getRow(2).getCell(13);
			 return formatter.formatCellValue(cell);						
		}
		
		private String getCVV() {
			 cell= getSheetS1().getRow(2).getCell(14);
			 return formatter.formatCellValue(cell);						
		}
		
		/**
	     * create excel file
	     *
	     * @return excel file path
	     */
	    private XSSFSheet getSheetS() {
	        return getTestData().getSheetAt(0);
	    }
		
	    
	    
		@Test(enabled=true,description = "Placed order using registered user with CC", groups = {"closed","checkout" })
		public void co_1() {
			
			reader.removeColumn("Registered_user", 15);
			reader.addColumn("Registered_user", "Order_ID");
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlStandard())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(1).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(1).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					.clkSecondDayAirShip()
					.clkShippingNextBtn() 
					.clkPrimaryPayment()
					.clkConfirmBtn()
					.clkPlaceOrderBtn();
				//System.out.println("Thank You for Shopping with us");
				
				String actual=co.getOrderId(); 
				  //System.out.println("Your Order # is " +actual);
				  
				  reader.setCellData("Registered_user", "Order_ID", 2, actual);
				
				/*
				 * String actual=co.paymentConfirmMessage(); Assert.assertEquals(actual,
				 * CheckoutTestData.PAYMENT_CONFIRM_MESSAGE);
				 */
				
		}
		
		@Test(enabled=false,description = "Placed order with registered user with Ground shipping using Visa CC", groups = {"closed","checkout" })
		public void co_2() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlStandard())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(2).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(2).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					  .enterGuestPhoneNo(getPhoneNo())
						.enterGuestAddress(getSheetS1().getRow(2).getCell(5).getStringCellValue())
						 .enterGuestCity(getSheetS1().getRow(2).getCell(6).getStringCellValue())
						 .selectGuestState(CheckoutTestData.STATE)
						 .enterGuestZip(getZipCode())
						 .clkInfoNextBtn() 
						 .clkShippingNextBtn()
						 .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
						 .enterNameOnCardCc(CheckoutTestData.NAME_ON_CARD)
						 .selectCardType(CheckoutTestData.CARD_TYPE)
						 .enterCardNoCc(getCardNo())
						 .enterExpiryMmCc(getEXDateMM())
						 .enterExpiryYyCc(getEXDateYY())
						 .enterCvvCc(getCVV())
						 .switchToPaymentPage()
						 .clkConfirmBtn()
						 .clkPlaceOrderBtn();
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 3, actual);
				
			
				/*
				 * String actual=co.paymentConfirmMessage(); Assert.assertEquals(actual,
				 * CheckoutTestData.PAYMENT_CONFIRM_MESSAGE);
				 */
			 
		}
		
		@Test(enabled=false,description = "Registered user with ground shipping using Master CC", groups = {"closed","checkout" })
		public void co_3() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlStandard())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(2).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(2).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					  .enterGuestPhoneNo(getPhoneNo())
						.enterGuestAddress(getSheetS1().getRow(2).getCell(5).getStringCellValue())
						 .enterGuestCity(getSheetS1().getRow(2).getCell(6).getStringCellValue())
						 .selectGuestState(CheckoutTestData.STATE)
						 .enterGuestZip(getZipCode())
						 .clkInfoNextBtn() 
						 .clkShippingNextBtn()
						 .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
						 .enterNameOnCardCc(CheckoutTestData.NAME_ON_CARD)
						 .selectCardType(CheckoutTestData.CARD_TYPE_MASTER)
						 .enterCardNoCc(getCardNo2())
						 .enterExpiryMmCc(getEXDateMM())
						 .enterExpiryYyCc(getEXDateYY())
						 .enterCvvCc(getCVV())
						 .switchToPaymentPage()
						 .clkConfirmBtn()
						 .clkPlaceOrderBtn();
			
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 4, actual);
			
				/*
				 * String actual=co.paymentConfirmMessage(); Assert.assertEquals(actual,
				 * CheckoutTestData.PAYMENT_CONFIRM_MESSAGE);
				 */
		}
		
		@Test(enabled=false,description = "Registered user with ground shipping using Amex CC", groups = {"closed","checkout" })
		public void co_4() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlStandard())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(4).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(4).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					  .enterGuestPhoneNo(getPhoneNo())
						.enterGuestAddress(getSheetS1().getRow(3).getCell(5).getStringCellValue())
						 .enterGuestCity(getSheetS1().getRow(3).getCell(6).getStringCellValue())
						 .selectGuestState(CheckoutTestData.STATE)
						 .enterGuestZip(getZipCode())
						 .clkInfoNextBtn() 
						 .clkShippingNextBtn()
						 .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
						 .enterNameOnCardCc(CheckoutTestData.NAME_ON_CARD)
						 .selectCardType(CheckoutTestData.CARD_TYPE_AMEX)
						 .enterCardNoCc(getCardNo3())
						 .enterExpiryMmCc(getEXDateMM())
						 .enterExpiryYyCc(getEXDateYY())
						 .enterCvvCc(getCVV())
						 .switchToPaymentPage()
						 .clkConfirmBtn()
						 .clkPlaceOrderBtn();
			
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 5, actual);
			
//			String actual=co.paymentConfirmMessage(); Assert.assertEquals(actual,
//					  CheckoutTestData.PAYMENT_CONFIRM_MESSAGE);
	}
		
		@Test(enabled=false,description = "Registered user with ground shipping using Disc CC", groups = {"closed","checkout" })
		public void co_5() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlStandard())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(5).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(5).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					  .enterGuestPhoneNo(getPhoneNo())
						.enterGuestAddress(getSheetS1().getRow(5).getCell(5).getStringCellValue())
						 .enterGuestCity(getSheetS1().getRow(5).getCell(6).getStringCellValue())
						 .selectGuestState(CheckoutTestData.STATE)
						 .enterGuestZip(getZipCode())
						 .clkInfoNextBtn() 
						 .clkShippingNextBtn()
						 .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
						 .enterNameOnCardCc(CheckoutTestData.NAME_ON_CARD)
						 .selectCardType(CheckoutTestData.CARD_TYPE_DISC)
						 .enterCardNoCc(getCardNo4())
						 .enterExpiryMmCc(getEXDateMM())
						 .enterExpiryYyCc(getEXDateYY())
						 .enterCvvCc(getCVV())
						 .switchToPaymentPage()
						 .clkConfirmBtn()
						 .clkPlaceOrderBtn();
			
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 6, actual);
			
				/*
				 * String actual=co.paymentConfirmMessage(); Assert.assertEquals(actual,
				 * CheckoutTestData.PAYMENT_CONFIRM_MESSAGE);
				 */
	}
		
		@Test(enabled=false,description = "Registered user with second day shipping using Visa CC")
		public void co_6() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlSecond())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(5).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(5).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					  .enterGuestPhoneNo(getPhoneNo())
						.enterGuestAddress(getSheetS1().getRow(5).getCell(5).getStringCellValue())
						 .enterGuestCity(getSheetS1().getRow(5).getCell(6).getStringCellValue())
						 .selectGuestState(CheckoutTestData.STATE)
						 .enterGuestZip(getZipCode())
						 .clkInfoNextBtn() 
			  .clkSecondDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheetS1().getRow(2).getCell(10).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE) 
			  .enterCardNoCc(getCardNo())
			  .enterExpiryMmCc(getEXDateMM()) 
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV()) 
			  .switchToPaymentPage() .clkConfirmBtn()
			  .clkPlaceOrderBtn(); 
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 7, actual);
	}
		
		@Test(enabled=false,description = "Registered user with second day shipping using Master CC")
		public void co_7() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlSecond())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(5).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(5).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					  .enterGuestPhoneNo(getPhoneNo())
						.enterGuestAddress(getSheetS1().getRow(5).getCell(5).getStringCellValue())
						 .enterGuestCity(getSheetS1().getRow(5).getCell(6).getStringCellValue())
						 .selectGuestState(CheckoutTestData.STATE)
						 .enterGuestZip(getZipCode())
						 .clkInfoNextBtn() 
			  .clkSecondDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheetS1().getRow(2).getCell(10).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_MASTER)
			  .enterCardNoCc(getCardNo2())
			  .enterExpiryMmCc(getEXDateMM())
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV())
			  .switchToPaymentPage()
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn();
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 8, actual);
	  
		}
			
		@Test(enabled=false,description = "Registered user with second day shipping using Amex CC")
		public void co_8() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlSecond())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(5).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(5).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					  .enterGuestPhoneNo(getPhoneNo())
						.enterGuestAddress(getSheetS1().getRow(5).getCell(5).getStringCellValue())
						 .enterGuestCity(getSheetS1().getRow(5).getCell(6).getStringCellValue())
						 .selectGuestState(CheckoutTestData.STATE)
						 .enterGuestZip(getZipCode())
						 .clkInfoNextBtn() 
			  .clkSecondDayAirShip()
			  .clkShippingNextBtn()
			  .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			  .enterNameOnCardCc(getSheetS1().getRow(3).getCell(10).getStringCellValue())
			  .selectCardType(CheckoutTestData.CARD_TYPE_AMEX)
			  .enterCardNoCc(getCardNo3())
			  .enterExpiryMmCc(getEXDateMM())
			  .enterExpiryYyCc(getEXDateYY())
			  .enterCvvCc(getCVV())
			  .switchToPaymentPage()
			  .clkConfirmBtn()
			  .clkPlaceOrderBtn();
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 9, actual);
			
		}
		
		@Test(enabled=false,description = "Registered user with second day shipping using Disc CC")
		public void co_9() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlSecond())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(5).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(5).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					.enterGuestPhoneNo(getPhoneNo())
				    .enterGuestAddress(getSheetS1().getRow(5).getCell(5).getStringCellValue())
					.enterGuestCity(getSheetS1().getRow(5).getCell(6).getStringCellValue())
					.selectGuestState(CheckoutTestData.STATE)
					.enterGuestZip(getZipCode())
					.clkInfoNextBtn() 
			        .clkSecondDayAirShip()
			        .clkShippingNextBtn()
			        .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			        .enterNameOnCardCc(getSheetS1().getRow(4).getCell(10).getStringCellValue())
			        .selectCardType(CheckoutTestData.CARD_TYPE_DISC)
			        .enterCardNoCc(getCardNo4())
			        .enterExpiryMmCc(getEXDateMM())
			        .enterExpiryYyCc(getEXDateYY())
			        .enterCvvCc(getCVV())
			        .switchToPaymentPage()
			        .clkConfirmBtn()
			        .clkPlaceOrderBtn();
			
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 10, actual);
		
	}
		
		@Test(enabled=false,description = "Registered user with next day shipping using Visa CC")
		public void co_10() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlNext())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(10).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(10).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					.enterGuestPhoneNo(getPhoneNo())
				    .enterGuestAddress(getSheetS1().getRow(5).getCell(5).getStringCellValue())
					.enterGuestCity(getSheetS1().getRow(5).getCell(6).getStringCellValue())
					.selectGuestState(CheckoutTestData.STATE)
					.enterGuestZip(getZipCode())
					.clkInfoNextBtn() 
					.clkNextDayAirShip()
			        .clkShippingNextBtn()
			        .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			        .enterNameOnCardCc(getSheetS1().getRow(4).getCell(10).getStringCellValue())
			        .selectCardType(CheckoutTestData.CARD_TYPE)
			        .enterCardNoCc(getCardNo())
			        .enterExpiryMmCc(getEXDateMM())
			        .enterExpiryYyCc(getEXDateYY())
			        .enterCvvCc(getCVV())
			        .switchToPaymentPage()
			        .clkConfirmBtn()
			        .clkPlaceOrderBtn();
			
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 11, actual);
		}
		
		@Test(enabled=false,description = "Registered user with next day shipping using Master CC")
		public void co_11() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlNext())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(11).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(11).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					.enterGuestPhoneNo(getPhoneNo())
				    .enterGuestAddress(getSheetS1().getRow(5).getCell(5).getStringCellValue())
					.enterGuestCity(getSheetS1().getRow(5).getCell(6).getStringCellValue())
					.selectGuestState(CheckoutTestData.STATE)
					.enterGuestZip(getZipCode())
					.clkInfoNextBtn() 
					.clkNextDayAirShip()
			        .clkShippingNextBtn()
			        .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			        .enterNameOnCardCc(getSheetS1().getRow(4).getCell(10).getStringCellValue())
			        .selectCardType(CheckoutTestData.CARD_TYPE_MASTER)
					  .enterCardNoCc(getCardNo2())
			        .enterExpiryMmCc(getEXDateMM())
			        .enterExpiryYyCc(getEXDateYY())
			        .enterCvvCc(getCVV())
			        .switchToPaymentPage()
			        .clkConfirmBtn()
			        .clkPlaceOrderBtn();
			
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 12, actual);
		}
		
		@Test(enabled=false,description = "Registered user with next day shipping using Amex CC")
		public void co_12() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlNext())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(12).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(12).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					.enterGuestPhoneNo(getPhoneNo())
				    .enterGuestAddress(getSheetS1().getRow(5).getCell(5).getStringCellValue())
					.enterGuestCity(getSheetS1().getRow(5).getCell(6).getStringCellValue())
					.selectGuestState(CheckoutTestData.STATE)
					.enterGuestZip(getZipCode())
					.clkInfoNextBtn() 
					.clkNextDayAirShip()
			        .clkShippingNextBtn()
			        .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			        .enterNameOnCardCc(getSheetS1().getRow(4).getCell(10).getStringCellValue())
			        .selectCardType(CheckoutTestData.CARD_TYPE_AMEX)
					  .enterCardNoCc(getCardNo3())
			        .enterExpiryMmCc(getEXDateMM())
			        .enterExpiryYyCc(getEXDateYY())
			        .enterCvvCc(getCVV())
			        .switchToPaymentPage()
			        .clkConfirmBtn()
			        .clkPlaceOrderBtn();
			
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 13, actual);
		}
		
		@Test(enabled=false,description = "Registered user with next day shipping using Discover CC")
		public void co_13() {
			
			co = new CheckoutPage(getDriver());
			co.getPdpCheckoutPage(getPageUrlNext())
			        .clkAddtoCartBtn()
			        .clkProceedToCartBtn()
			        .clkCheckoutBtn()
			        .enterUname(getSheetS1().getRow(13).getCell(1).getStringCellValue())
			        .enterPass(getSheetS1().getRow(13).getCell(2).getStringCellValue())
					.clkSubmitBtn()
					.clkCookiesCrossBtn()
					.scrolltoInfoNextBtn()
					.clkInfoNextBtn()
					.enterGuestPhoneNo(getPhoneNo())
				    .enterGuestAddress(getSheetS1().getRow(5).getCell(5).getStringCellValue())
					.enterGuestCity(getSheetS1().getRow(5).getCell(6).getStringCellValue())
					.selectGuestState(CheckoutTestData.STATE)
					.enterGuestZip(getZipCode())
					.clkInfoNextBtn() 
					.clkNextDayAirShip()
			        .clkShippingNextBtn()
			        .switchToPaymentIframe(CheckoutTestData.IFRAME_ID)
			        .enterNameOnCardCc(getSheetS1().getRow(4).getCell(10).getStringCellValue())
			        .selectCardType(CheckoutTestData.CARD_TYPE_DISC)
					  .enterCardNoCc(getCardNo4())
			        .enterExpiryMmCc(getEXDateMM())
			        .enterExpiryYyCc(getEXDateYY())
			        .enterCvvCc(getCVV())
			        .switchToPaymentPage()
			        .clkConfirmBtn()
			        .clkPlaceOrderBtn();
			
			//System.out.println("Thank You for Shopping with us");
			String actual=co.getOrderId(); 
			reader.setCellData("Registered_user", "Order ID", 14, actual);
		}
	}