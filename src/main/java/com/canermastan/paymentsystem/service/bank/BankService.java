package com.canermastan.paymentsystem.service.bank;

import com.canermastan.paymentsystem.entity.CreditCard;
import com.canermastan.paymentsystem.service.CreditCardService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    private final CreditCardService creditCardService;

    public BankService(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    /**
     * Bank Latency Simulation (avg: 5 seconds)
     */
    public BankPaymentResponse pay(BankPaymentRequest request) throws Exception {
        try {
            CreditCard cc = creditCardService.findByNumber(request.getCreditCardDto().getNumber());
            if (cc == null) {
                throw new Exception("Credit card not found!");
            }
            if(!cc.getCcv().equals(DigestUtils.sha256Hex(request.getCreditCardDto().getCcv())) &&
                    !cc.getExpMonth().equals(DigestUtils.sha256Hex(request.getCreditCardDto().getExpMonth())) &&
            		!cc.getExpYear().equals(DigestUtils.sha256Hex(request.getCreditCardDto().getExpYear()))) {
            	throw new Exception("Credit card information is not correct!");
            }

            if (request.getPrice().compareTo(cc.getAmount()) == 1) {
                throw new Exception("Kart tutarı yetersiz.");
            }

            creditCardService.decreaseAmount(request.getPrice(), cc.getNumber());

            Thread.sleep(5000);
            return new BankPaymentResponse("200");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
