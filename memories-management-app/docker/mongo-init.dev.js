print('mongo-init.dev.js started...');

db.auth('mongo', 'mongo');

const devDatabaseName = 'rm-memories-mngmt';

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

// Occur an error when running here
// rs.initiate();

print('mongo-init.dev.js finished')
