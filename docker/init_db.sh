set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE kufantasy;
    CREATE DATABASE kufantasy_test;
    CREATE USER docker WITH ENCRYPTED PASSWORD 'docker';
    GRANT ALL PRIVILEGES ON DATABASE kufantasy TO docker;
    GRANT ALL PRIVILEGES ON DATABASE kufantasy_test TO docker;
EOSQL