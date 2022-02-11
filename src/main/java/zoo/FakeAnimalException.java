package zoo;

public class FakeAnimalException extends Exception{

    public FakeAnimalException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
