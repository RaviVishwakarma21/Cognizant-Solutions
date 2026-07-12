-- scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Update all savings accounts by adding 1% interest to the current balance
    UPDATE accounts 
    SET balance = balance * 1.01
    WHERE account_type = 'SAVINGS';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully for all savings accounts.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END;
/

-- scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Update employee salaries within the specified department
    UPDATE employees
    SET salary = salary * (1 + (p_bonus_percentage / 100))
    WHERE department_id = p_department_id;
    
    DBMS_OUTPUT.PUT_LINE('Bonus updated successfully for department ' || p_department_id || '.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
END;
/

-- scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN NUMBER,
    p_dest_account   IN NUMBER,
    p_amount         IN NUMBER
) IS
    v_source_balance NUMBER;
    insufficient_balance EXCEPTION;
BEGIN
    -- 1. Fetch current balance of the source account
    SELECT balance INTO v_source_balance 
    FROM accounts 
    WHERE account_id = p_source_account;
    
    -- 2. Validate that the source has enough funds
    IF v_source_balance < p_amount THEN
        RAISE insufficient_balance;
    END IF;
    
    -- 3. Deduct from source account
    UPDATE accounts 
    SET balance = balance - p_amount 
    WHERE account_id = p_source_account;
    
    -- 4. Credit to destination account
    UPDATE accounts 
    SET balance = balance + p_amount 
    WHERE account_id = p_dest_account;
    
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from account ' || p_source_account || ' to ' || p_dest_account);
    COMMIT;

EXCEPTION
    WHEN insufficient_balance THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Aborted: Account ' || p_source_account || ' has insufficient funds.');
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Aborted: One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Error: ' || SQLERRM);
END;
/