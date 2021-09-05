
interface Strategy
{
    int doAction(int a , int b);
}


class StrategyAdd implements Strategy
{
    @Override
    public int doAction(int a , int b){

        return a+b;

    }
}

class StrategySub implements Strategy
{
    @Override
    public int doAction(int a , int b)
    {
        return a-b;
    }
}

class StrategyMul implements Strategy
{
    @Override
    public int doAction(int a , int b)
    {
        return a*b;
    }
}

class OpContext
{
    private Strategy strategy;

    public OpContext(String choice)
    {
        if(choice.equalsIgnoreCase("add"))
            this.strategy=new StrategyAdd();
        else if(choice.equalsIgnoreCase("sub"))
            this.strategy=new StrategySub();
        else if(choice.equalsIgnoreCase("mul"))
            this.strategy=new StrategyMul();
    }


    public int applyStrategy(int a, int b)
    {
        return strategy.doAction(a, b);
    }

}

class Client
{
    public static void main(String[] args)
    {
        System.out.println("***Strategy Pattern Demo***\n");

        //First time add
        OpContext context = new OpContext("add");
        int res= context.applyStrategy(6, 7);

        //Second time sub
        context = new OpContext("sub");

        res= context.applyStrategy(6, 7);

        //Third time sub
        context = new OpContext("mul");

        res= context.applyStrategy(6, 7);
    }
}



