package lotto.controller;

import java.util.List;

import lotto.common.RequestMessage;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.utils.StringUtils;
import lotto.view.RequestView;
import lotto.view.ResponseView;

public class LottoController {

	private static final LottoController INSTANCE = new LottoController();

	private final RequestView requestView;
	private final ResponseView responseView;
	private final LottoService lottoService;

	private LottoController() {
		this.lottoService = LottoService.getInstance();
		this.requestView = RequestView.getInstance();
		this.responseView = ResponseView.getInstance();
	}

	public static LottoController getInstance() {
		return INSTANCE;
	}

	public void run() {
		int amount = StringUtils.toNumber(
			requestView.inputWithMessage(RequestMessage.LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage()));
		List<Lotto> boughtLotto = lottoService.buy(amount);
		responseView.printBoughtLotto(boughtLotto);

		// TODO: 당첨 번호 입력

		// TODO: 보너스 번호 입력

		// TODO: 당첨 통계
	}
}
