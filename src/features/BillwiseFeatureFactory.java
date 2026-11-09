package features;

public class BillwiseFeatureFactory extends FeatureFactory {

    @Override
    public SubscriptionFeature createFeature(int choice) {

        switch (choice) {

            case 1:
                return new AddSubscription();

            case 2:
                return new UpdateSubscription();

            case 3:
                return new ViewAllSubscription();

            case 4:
                return new DeleteSubscription();

            case 5:
                return new SearchSubscription();

            case 6:
                return new UpcomingSubscription();

            case 7:
                return new MonthlyExpense(); 

            case 8:
                return new AnnualExpenses();

            default:
                return null;
        }
    }
}