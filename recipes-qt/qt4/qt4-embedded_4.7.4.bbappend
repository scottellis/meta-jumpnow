FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

QT_SQL_DRIVER_FLAGS = "-no-sql-ibase -no-sql-mysql -no-sql-odbc -no-sql-psql -no-sql-sqlite2 -no-sql-sqlite"

QT_CONFIG_FLAGS += "-no-iconv"

PRINC := "${@int(PRINC) + 1}"

