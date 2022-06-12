package exchange.rate.exchangetest.domain.entity;

public enum Currency {
    KRW {
        @Override
        public String getQuotes() {
            return "USDKRW";
        }
    },
    PHP{
        @Override
        public String getQuotes() {
            return "USDPHP";
        }
    },
    JPY{
        @Override
        public String getQuotes() {
            return "USDJPY";
        }
    };
    abstract public String getQuotes();
}
