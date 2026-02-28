INSERT INTO cars (id, make, model, registration_number, manufacture_year, daily_rate)
VALUES
    (1, 'Toyota', 'Corolla', 'REG-001', 2018, 45.00),
    (2, 'Volkswagen', 'Golf', 'REG-002', 2024, 55.00),
    (3, 'Ford', 'Focus', 'REG-003', 2019, 50.00);

INSERT INTO bookings (id, car_id, customer_name, customer_email, start_date, end_date, total_amount, status)
VALUES
    (1, 1, 'Alice Johnson', 'alice@example.com', '2025-01-10', '2025-01-12', 90.00, 'CONFIRMED'),
    (2, 1, 'Bob Smith', 'bob@example.com', '2025-02-01', '2025-02-05', 180.00, 'CREATED'),
    (3, 2, 'Charlie Brown', 'charlie@example.com', '2025-03-15', '2025-03-18', 165.00, 'CONFIRMED');
