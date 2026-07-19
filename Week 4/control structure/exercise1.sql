-- Scenario 1: Senior Discount
DECLARE
    CURSOR c_customers IS SELECT customer_id, age, interest_rate FROM customers;
BEGIN
    FOR r_cust IN c_customers LOOP
        IF r_cust.age > 60 THEN
            UPDATE customers SET interest_rate = interest_rate - 1 WHERE customer_id = r_cust.customer_id;
            DBMS_OUTPUT.PUT_LINE('Discount applied for Customer ID: ' || r_cust.customer_id);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: VIP Status promotion
DECLARE
    CURSOR c_vip_check IS SELECT customer_id, balance FROM customers;
BEGIN
    FOR r_cust IN c_vip_check LOOP
        IF r_cust.balance > 10000 THEN
            UPDATE customers SET IsVIP = 'TRUE' WHERE customer_id = r_cust.customer_id;
            DBMS_OUTPUT.PUT_LINE('Customer ' || r_cust.customer_id || ' promoted to VIP.');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Loan Due Reminders
DECLARE
    CURSOR c_due_loans IS 
        SELECT customer_id, loan_id, due_date 
        FROM loans 
        WHERE due_date BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- LOAN DUE REMINDERS (NEXT 30 DAYS) ---');
    FOR r_loan IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ID ' || r_loan.customer_id || ' - Loan ID ' || r_loan.loan_id || ' is due on ' || TO_CHAR(r_loan.due_date, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/