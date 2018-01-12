package com.mayhsupaing.burpple.data.vo.model;

import com.mayhsupaing.burpple.network.PromotionDataAgent;
import com.mayhsupaing.burpple.network.PromotionOKHttpDataAgent;
import com.mayhsupaing.burpple.network.PromotionRetrofitDataAgent;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class PromotionModel {

    private PromotionDataAgent sPromotionDataAgent;

    private static PromotionModel sObjInstance;

    private PromotionModel(){

        //sPromotionDataAgent= PromotionOKHttpDataAgent.getsObjInstance();
        sPromotionDataAgent= PromotionRetrofitDataAgent.getsObjInstance();
    }

    public static PromotionModel getsObjInstance(){
        if(sObjInstance==null)
        {
            sObjInstance=new PromotionModel();
        }
        return sObjInstance;
    }

    public void LoadPromotion(){
        sPromotionDataAgent.loadPromotion();
    }
}
