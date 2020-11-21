print('mongo-init.dev.js started...');

db.auth('mongo', 'mongo');

db.createUser({
    user: 'kafka-source-connector',
    pwd: 'kafka-source-connector',
    roles: [
        {
            role: 'readAnyDatabase',
            db: 'admin',
        },
    ],
});

db.createUser({
    user: 'kafka-sink-connector',
    pwd: 'kafka-sink-connector',
    roles: [
        {
            role: 'readWriteAnyDatabase',
            db: 'admin',
        },
    ],
});

const devDatabaseName = 'rememory-remembrance-management';

const devDatabase = db.getSiblingDB(devDatabaseName);

devDatabase.createUser({
    user: devDatabaseName,
    pwd: devDatabaseName,
    roles: [
        {
            role: 'dbOwner',
            db: devDatabaseName,
        },
    ],
});

print('mongo-init.dev.js finished')

// Occur an error when running here
// rs.initiate();
