package database;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

public final class Repository {
    private static Repository INSTANCE;

    public static Repository getInstance() {
        if(INSTANCE == null)
            INSTANCE = new Repository();
        return INSTANCE;
    }

    public static DynamoDbTable<Item> getTable() {
        return table;
    }

    private static final DynamoDbTable<Item> table =
            DynamoDB.getInstanceDynamoDb().table(
                    "item", TableSchema.fromBean(Item.class));

    /**
     * Atualiza item.
     */
    public void update(Item item){
        table.updateItem(item);
    }

    /**
     * Cria item.
     */
    public void create(Item item){
        table.putItem(item);
    }

    public Item get(String id){
        Key key = Key.builder()
                .partitionValue(id)
                .build();

        return table.getItem(key);
    }
}
