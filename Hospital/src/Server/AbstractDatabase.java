package Server;

public abstract class AbstractDatabase {
	public abstract boolean insert(String table, String add);
	public abstract boolean delete(String table, String field, String target);
}
