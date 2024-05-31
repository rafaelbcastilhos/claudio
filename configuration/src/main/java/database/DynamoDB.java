package database;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoDB {
    private static DynamoDbEnhancedClient INSTANCE_MAPPER;
    static AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
            "ACCESS_KEY",
            "SECRET_KEY");

    // DynamoDB Client construtor
    private static final DynamoDbClient mapper = DynamoDbClient
            .builder()
            .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
            .region(Region.US_EAST_1)
            .build();

    // Singleton da classe DynamoDbEnhancedClient.
    public static DynamoDbEnhancedClient getInstanceDynamoDb() {
        System.out.println(awsCreds.accessKeyId());
        System.out.println(awsCreds.secretAccessKey());
        if(INSTANCE_MAPPER == null)
            INSTANCE_MAPPER = DynamoDbEnhancedClient.builder()
                    .dynamoDbClient(mapper)
                    .build();

        return INSTANCE_MAPPER;
    }
}
