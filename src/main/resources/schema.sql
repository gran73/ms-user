

-- ----------------------------------------------
-- DDL Statements for tables
-- ----------------------------------------------

CREATE TABLE "PURCHASES" ("ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "CUSTOMER_ID" INTEGER, "PRODUCT" VARCHAR(255), "PURCHASE_DATE" TIMESTAMP);
CREATE TABLE "USERS" ("ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "NAME" VARCHAR(60), "EMAIL" VARCHAR(255), "PASSWORD" VARCHAR(60));
-- ----------------------------------------------
-- DDL Statements for keys
-- ----------------------------------------------

-- primary/unique
ALTER TABLE "PURCHASES" ADD CONSTRAINT "SQL120325130144010" PRIMARY KEY ("ID");
ALTER TABLE "USERS" ADD CONSTRAINT "SQL120325130144011" PRIMARY KEY ("ID");

