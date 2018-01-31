
package com.att.idp.ms.pricingpromotion.common;
/**
 * QueryConstants.java 
 */
public class QueryConstants {

	/**
	 * zip9
	 */
	public static final String ZIP9="zip9";

	/**
	 * customerType
	 */
	public static final String CUTOMERTYPE="customerType";

	/**
	 * flowType
	 */
	public static final String FLOWTYPE="flowType";

	/**
	 * subFlowType
	 */
	public static final String SUBFLOWTYPE="subFlowType";

	/**
	 * zip
	 */
	public static final String ZIP="zip";

	/**
	 * dma
	 */
	public static final String DMA="dma";

	/**
	 * city
	 */
	public static final String CITY="city";

	/**
	 * state
	 */
	public static final String STATE="state";

	/**
	 * nation
	 */
	public static final String NATION="nation";
	
	/**
	 * SINGLE_QUOTE
	 */
	public static final String SINGLE_QUOTE="\'";
	
	
	/**
	 * priceQuery
	 */
//	public static String priceQuery = "SELECT default.skuId, priceInfo.price, priceInfo.location, priceInfo.locationType"
	public static String priceQuery = "SELECT default.skuId, priceInfo.price, priceInfo.locationType"
         +" FROM default AS default UNNEST gfInfo AS gfInfo  UNNEST gfInfo.pricingInfo AS priceInfo"
         + " WHERE default.skuId IN [{0}]"
         + " AND gfInfo.salesEffectiveDate <= NOW_STR() AND gfInfo.salesExpirationDate > NOW_STR()"
         + " AND priceInfo.premiumTier={1} AND priceInfo.salesEffectiveDate <= NOW_STR()"
         + " AND priceInfo.salesExpirationDate >= NOW_STR() AND priceInfo.customerSubType = {2}"
         + " AND ((priceInfo.locationType = {3} AND priceInfo.location = {4}) OR"
         + " (priceInfo.locationType = {5} AND priceInfo.location = {6}) OR" 
         + " (priceInfo.locationType = {7} AND priceInfo.location = {8}) OR"
         + " (priceInfo.locationType = {9} AND priceInfo.location = {10}) OR"
         + " (priceInfo.locationType = {11} AND priceInfo.location = {12}) OR"
         + " (priceInfo.locationType = {13} AND priceInfo.location = {14}))"
         + " ORDER BY (CASE WHEN priceInfo.locationType = {15} THEN 1"
         + " WHEN priceInfo.locationType = {16} THEN 2"
         + " WHEN priceInfo.locationType = {17} THEN 3"
         + " WHEN priceInfo.locationType = {18} THEN 4"
         + " WHEN priceInfo.locationType = {19} THEN 5"
         + " WHEN priceInfo.locationType = {20} THEN 6"
         + " ELSE 7 END);";
	
	/**
	 * promotionQuery
	 */
	public static String promotionQuery = "SELECT default.promotionId, elgblty.eligibilityId, elgblty.locationType, elgblty.ranking, default.promoType, default.amount,"
			+ " default.promoLevel, productId, default.saleType from default default UNNEST eligibilities elgblty"
			+ " UNNEST default.productId as productId WHERE default.doc_type = {0}"
			+ " AND productId IN [{1}]"
			+ " AND ANY customerType IN default.customerTypes SATISFIES customerType IN [{2}]"
			+ " END AND ANY pricingMethod IN default.pricingMethods SATISFIES pricingMethod IN [{3}]"
			+ " END AND default.excludedFlowType != {4} AND elgblty.salesEffectiveDate <= NOW_STR() AND elgblty.salesExpirationDate >= NOW_STR()"
			+ " AND elgblty.customerSubType = {5} AND elgblty.premiumTier = {6} AND elgblty.actionType = {7}"
			+ " AND ANY qualifyProduct IN elgblty.qualifyProductsOR SATISFIES qualifyProduct IN [{8}"
			+ " END AND ANY qualifyIndicators IN [{9},{10}]"
			+ " SATISFIES (ANY AND EVERY qualifyInd IN qualifyIndicators SATISFIES (ANY qualInd WITHIN default.qualifyIndicatorAND SATISFIES qualInd = qualifyInd END)  END) END"
			+ " AND ((elgblty.locationType = {11} AND elgblty.location = {12}) OR"
			+ " (elgblty.locationType = {13} AND elgblty.location = {14}) OR"
			+ " (elgblty.locationType = {15} AND elgblty.location = {16}) OR"
			+ " (elgblty.locationType = {17} AND elgblty.location = {18}) OR"
			+ " (elgblty.locationType = {19} AND elgblty.location = {20}) OR"
			+ " (elgblty.locationType = {21} AND elgblty.location = {22}))"
			+ " ORDER BY (CASE WHEN elgblty.locationType = {23} THEN 1"
			+ " WHEN elgblty.locationType = {24} THEN 2"
			+ " WHEN elgblty.locationType = {25} THEN 3"
			+ " WHEN elgblty.locationType = {26} THEN 4"
			+ " WHEN elgblty.locationType = {27} THEN 5"
			+ " WHEN elgblty.locationType = {28} THEN 6"
			+ " ELSE 7 END), elgblty.ranking;";
	
	/**
	 * promotion
	 */
	public static final String DOCTYPE="promotion";

	/**
	 * basic
	 */
	public static final String SALE_TYPE="basic";

	/**
	 * PRICING_METHOD
	 */
	public static final String PRICING_METHOD="Acquisition";
	/**
	 * EXCLUDED_FLOW_TYPE
	 */
	public static final String EXCLUDED_FLOW_TYPE="provide";
	/**
	 * CUSTMER_SUB_TYPE
	 */
	public static final String CUSTMER_SUB_TYPE="smallbusiness";
	/**
	 * PREMIUM_TYRE
	 */
	public static final String PREMIUM_TYRE="NP";
	/**
	 * ACTION_TYPE
	 */
	public static final String ACTION_TYPE="A";
	/**
	 * QUALIFY_PRODUCT
	 */
	public static final String QUALIFY_PRODUCT="prod1145533";
	
	/**
	 * 
	 *//*
	public static String priceQueryPart1 = "SELECT default.skuId, default.productId, priceInfo.price, priceInfo.location, priceInfo.locationType"
			+" FROM `default` AS default"
			+" UNNEST gfInfo AS gfInfo"
			+" UNNEST gfInfo.pricingInfo AS priceInfo"
			+" WHERE default.skuId IN [{0}";

	*//**
	 * 
	 *//*
	public static String priceQueryPart2 = " AND default.outOfStock = false"
			+" AND default.skuStartDate <= NOW_STR() AND default.skuEndDate >= NOW_STR()"
			+" AND gfInfo.salesEffectiveDate <= NOW_STR() AND gfInfo.salesExpirationDate > NOW_STR()"
			+" AND priceInfo.premiumTier={0} AND priceInfo.salesEffectiveDate <= NOW_STR()"
			+" AND priceInfo.salesExpirationDate >= NOW_STR() AND priceInfo.customerSubType = {1}";

	*//**
	 * 
	 *//*
	public static String priceQueryPart3 = " AND ((priceInfo.locationType = {0} AND priceInfo.location = {1}) OR";

	*//**
	 * 
	 *//*
	public static String priceQueryPart4 = " (priceInfo.locationType = {0} AND priceInfo.location = {1}) OR";

	*//**
	 * 
	 *//*
	public static String priceQueryPart5 = " (priceInfo.locationType = {0} AND priceInfo.location = {1}) OR";

	*//**
	 * 
	 *//*
	public static String priceQueryPart6 = " (priceInfo.locationType = {0} AND priceInfo.location = {1}) OR";

	*//**
	 * 
	 *//*
	public static String priceQueryPart7 = " (priceInfo.locationType = {0} AND priceInfo.location = {1}) OR";

	*//**
	 * 
	 *//*
	public static String priceQueryPart8 = " (priceInfo.locationType = {0} AND priceInfo.location = {1}))";

	*//**
	 * 
	 *//*
	public static String priceQueryPart9 = " ORDER BY (CASE WHEN priceInfo.locationType = {0} THEN 1"
			+" WHEN priceInfo.locationType = {1} THEN 2"
			+" WHEN priceInfo.locationType = {2} THEN 3"
			+" WHEN priceInfo.locationType = {3} THEN 4"
			+" WHEN priceInfo.locationType = {4} THEN 5"
			+" WHEN priceInfo.locationType = {5} THEN 6"
			+" ELSE 7 END)"
			+" LIMIT 2;";*/


	/**
	 * 
	 *//*
	public static String pricePromotionsQuery1 = "SELECT default.promotionId, elgblty.eligibilityId, default.promoType, default.amount, default.promoLevel"
			+" from default default"
			+" UNNEST eligibilities elgblty"
			+"  WHERE default.doc_type = {0} AND default.saleType = {1}";

	*//**
	 * 
	 *//*
	public static String pricePromotionsQuery2 =" AND ANY prodId IN default.productId SATISFIES prodId IN [{0}";
	*//**
	 * 
	 *//*
	public static String pricePromotionsQuery3 =" END AND ANY customerType IN default.customerTypes SATISFIES customerType IN [{0}";

	public static String pricePromotionsQuery4 =" END AND ANY pricingMethod IN default.pricingMethods SATISFIES pricingMethod IN [{0}]";


	public static String pricePromotionsQuery5 =" END AND default.excludedFlowType != {0} AND elgblty.salesEffectiveDate <= NOW_STR() "
			+ "AND elgblty.salesExpirationDate >= NOW_STR()"
			+" AND elgblty.customerSubType = {1} AND elgblty.premiumTier = {2} AND elgblty.actionType = {3}"
			+" AND ANY qualifyProduct IN elgblty.qualifyProductsOR SATISFIES qualifyProduct IN [{4}]";


	public static String pricePromotionsQuery6 = " END AND ((elgblty.locationType = {0} AND elgblty.location = {1}) OR";

	public static String pricePromotionsQuery7 = " (elgblty.locationType = {0} AND elgblty.location = {1}) OR";

	public static String pricePromotionsQuery8 = " (elgblty.locationType = {0} AND elgblty.location = {1}) OR";

	public static String pricePromotionsQuery9 = " (elgblty.locationType = {0} AND elgblty.location = {1}) OR";

	public static String pricePromotionsQuery10 = " (elgblty.locationType = {0} AND elgblty.location = {1}) OR";

	public static String pricePromotionsQuery11 = " (elgblty.locationType = {0} AND elgblty.location = {1}))";

	public static String pricePromotionsQuery12 =" ORDER BY (CASE WHEN elgblty.locationType = {0} THEN 1 "
			+ "WHEN elgblty.locationType = {1} THEN 2"
			+" WHEN elgblty.locationType = {2} THEN 3"
			+" WHEN elgblty.locationType = {3} THEN 4"
			+" WHEN elgblty.locationType = {4} THEN 5"
			+" WHEN elgblty.locationType = {5} THEN 6"
			+" ELSE 7 END), elgblty.ranking"
			+" LIMIT 1;";
*/

}
