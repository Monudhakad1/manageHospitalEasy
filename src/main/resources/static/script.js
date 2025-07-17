const API_BASE_URL = '/api/v1';

// Global variables to store data
let patients = [];
let doctors = [];
let appointments = [];
let bills = [];

// Initialize the application
document.addEventListener('DOMContentLoaded', function() {
    loadAllData();
    setupEventListeners();
});

// Setup event listeners
function setupEventListeners() {
    document.getElementById('patientForm').addEventListener('submit', handlePatientSubmit);
    document.getElementById('doctorForm').addEventListener('submit', handleDoctorSubmit);
    document.getElementById('appointmentForm').addEventListener('submit', handleAppointmentSubmit);
    document.getElementById('billForm').addEventListener('submit', handleBillSubmit);
}

// Navigation functions
function showSection(sectionName) {
    // Hide all sections
    document.querySelectorAll('.content-section').forEach(section => {
        section.classList.remove('active');
    });

    // Remove active class from all nav buttons
    document.querySelectorAll('.nav-btn').forEach(btn => {
        btn.classList.remove('active');
    });

    // Show selected section
    document.getElementById(sectionName).classList.add('active');

    // Add active class to clicked nav button
    event.target.classList.add('active');

    // Load data for the section
    loadSectionData(sectionName);
}

// Load data for specific section
function loadSectionData(sectionName) {
    switch(sectionName) {
        case 'patients':
            loadPatients();
            break;
        case 'doctors':
            loadDoctors();
            break;
        case 'appointments':
            loadAppointments();
            break;
        case 'bills':
            loadBills();
            break;
    }
}

// Load all data
function loadAllData() {
    loadPatients();
    loadDoctors();
    loadAppointments();
    loadBills();
}

// Patient functions
async function loadPatients() {
    try {
        const response = await fetch(`${API_BASE_URL}/patients`);
        patients = await response.json();
        renderPatientsTable();
        updatePatientDropdowns();
    } catch (error) {
        console.error('Error loading patients:', error);
        alert('Error loading patients');
    }
}

function renderPatientsTable() {
    const tbody = document.getElementById('patientsTableBody');
    tbody.innerHTML = '';

    patients.forEach(patient => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${patient.id}</td>
            <td>${patient.name}</td>
            <td>${patient.gender}</td>
            <td>${patient.age}</td>
            <td class="action-buttons">
                <button class="btn btn-warning btn-sm" onclick="editPatient(${patient.id})">
                    <i class="fas fa-edit"></i> Edit
                </button>
                <button class="btn btn-danger btn-sm" onclick="deletePatient(${patient.id})">
                    <i class="fas fa-trash"></i> Delete
                </button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

async function handlePatientSubmit(event) {
    event.preventDefault();

    const id = document.getElementById('patientId').value;
    const patient = {
        name: document.getElementById('patientName').value,
        gender: document.getElementById('patientGender').value,
        age: document.getElementById('patientAge').value
    };

    try {
        let response;
        if (id) {
            // Update existing patient
            response = await fetch(`${API_BASE_URL}/patients/${id}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(patient)
            });
        } else {
            // Create new patient
            response = await fetch(`${API_BASE_URL}/patients`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(patient)
            });
        }

        if (response.ok) {
            hideForm('patient');
            loadPatients();
            alert(id ? 'Patient updated successfully!' : 'Patient added successfully!');
        } else {
            alert('Error saving patient');
        }
    } catch (error) {
        console.error('Error saving patient:', error);
        alert('Error saving patient');
    }
}

function editPatient(id) {
    const patient = patients.find(p => p.id === id);
    if (patient) {
        document.getElementById('patientId').value = patient.id;
        document.getElementById('patientName').value = patient.name;
        document.getElementById('patientGender').value = patient.gender;
        document.getElementById('patientAge').value = patient.age;
        document.getElementById('patient-form-title').textContent = 'Edit Patient';
        document.getElementById('patient-form').style.display = 'block';
    }
}

async function deletePatient(id) {
    if (confirm('Are you sure you want to delete this patient?')) {
        try {
            const response = await fetch(`${API_BASE_URL}/patients/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                loadPatients();
                alert('Patient deleted successfully!');
            } else {
                alert('Error deleting patient');
            }
        } catch (error) {
            console.error('Error deleting patient:', error);
            alert('Error deleting patient');
        }
    }
}

// Doctor functions
async function loadDoctors() {
    try {
        const response = await fetch(`${API_BASE_URL}/doctor`);
        doctors = await response.json();
        renderDoctorsTable();
        updateDoctorDropdowns();
    } catch (error) {
        console.error('Error loading doctors:', error);
        alert('Error loading doctors');
    }
}

function renderDoctorsTable() {
    const tbody = document.getElementById('doctorsTableBody');
    tbody.innerHTML = '';

    doctors.forEach(doctor => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${doctor.id}</td>
            <td>${doctor.name}</td>
            <td>${doctor.specialty}</td>
            <td class="action-buttons">
                <button class="btn btn-warning btn-sm" onclick="editDoctor(${doctor.id})">
                    <i class="fas fa-edit"></i> Edit
                </button>
                <button class="btn btn-danger btn-sm" onclick="deleteDoctor(${doctor.id})">
                    <i class="fas fa-trash"></i> Delete
                </button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

async function handleDoctorSubmit(event) {
    event.preventDefault();

    const id = document.getElementById('doctorId').value;
    const doctor = {
        name: document.getElementById('doctorName').value,
        specialty: document.getElementById('doctorSpecialty').value
    };

    try {
        let response;
        if (id) {
            response = await fetch(`${API_BASE_URL}/doctor/${id}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(doctor)
            });
        } else {
            response = await fetch(`${API_BASE_URL}/doctor`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(doctor)
            });
        }

        if (response.ok) {
            hideForm('doctor');
            loadDoctors();
            alert(id ? 'Doctor updated successfully!' : 'Doctor added successfully!');
        } else {
            alert('Error saving doctor');
        }
    } catch (error) {
        console.error('Error saving doctor:', error);
        alert('Error saving doctor');
    }
}

function editDoctor(id) {
    const doctor = doctors.find(d => d.id === id);
    if (doctor) {
        document.getElementById('doctorId').value = doctor.id;
        document.getElementById('doctorName').value = doctor.name;
        document.getElementById('doctorSpecialty').value = doctor.specialty;
        document.getElementById('doctor-form-title').textContent = 'Edit Doctor';
        document.getElementById('doctor-form').style.display = 'block';
    }
}

async function deleteDoctor(id) {
    if (confirm('Are you sure you want to delete this doctor?')) {
        try {
            const response = await fetch(`${API_BASE_URL}/doctor/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                loadDoctors();
                alert('Doctor deleted successfully!');
            } else {
                alert('Error deleting doctor');
            }
        } catch (error) {
            console.error('Error deleting doctor:', error);
            alert('Error deleting doctor');
        }
    }
}

// Appointment functions
async function loadAppointments() {
    try {
        const response = await fetch(`${API_BASE_URL}/appointments`);
        appointments = await response.json();
        renderAppointmentsTable();
    } catch (error) {
        console.error('Error loading appointments:', error);
        alert('Error loading appointments');
    }
}

function renderAppointmentsTable() {
    const tbody = document.getElementById('appointmentsTableBody');
    tbody.innerHTML = '';

    appointments.forEach(appointment => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${appointment.id}</td>
            <td>${appointment.patientId}</td>
            <td>${appointment.doctorId}</td>
            <td>${appointment.date}</td>
            <td class="action-buttons">
                <button class="btn btn-warning btn-sm" onclick="editAppointment(${appointment.id})">
                    <i class="fas fa-edit"></i> Edit
                </button>
                <button class="btn btn-danger btn-sm" onclick="deleteAppointment(${appointment.id})">
                    <i class="fas fa-trash"></i> Delete
                </button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

async function handleAppointmentSubmit(event) {
    event.preventDefault();

    const id = document.getElementById('appointmentId').value;
    const appointment = {
        patientId: parseInt(document.getElementById('appointmentPatient').value),
        doctorId: parseInt(document.getElementById('appointmentDoctor').value),
        date: document.getElementById('appointmentDate').value
    };

    try {
        let response;
        if (id) {
            response = await fetch(`${API_BASE_URL}/appointments/${id}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(appointment)
            });
        } else {
            response = await fetch(`${API_BASE_URL}/appointments`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(appointment)
            });
        }

        if (response.ok) {
            hideForm('appointment');
            loadAppointments();
            alert(id ? 'Appointment updated successfully!' : 'Appointment added successfully!');
        } else {
            alert('Error saving appointment');
        }
    } catch (error) {
        console.error('Error saving appointment:', error);
        alert('Error saving appointment');
    }
}

function editAppointment(id) {
    const appointment = appointments.find(a => a.id === id);
    if (appointment) {
        document.getElementById('appointmentId').value = appointment.id;
        document.getElementById('appointmentPatient').value = appointment.patientId;
        document.getElementById('appointmentDoctor').value = appointment.doctorId;
        document.getElementById('appointmentDate').value = appointment.date;
        document.getElementById('appointment-form-title').textContent = 'Edit Appointment';
        document.getElementById('appointment-form').style.display = 'block';
    }
}

async function deleteAppointment(id) {
    if (confirm('Are you sure you want to delete this appointment?')) {
        try {
            const response = await fetch(`${API_BASE_URL}/appointments/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                loadAppointments();
                alert('Appointment deleted successfully!');
            } else {
                alert('Error deleting appointment');
            }
        } catch (error) {
            console.error('Error deleting appointment:', error);
            alert('Error deleting appointment');
        }
    }
}

// Bill functions
async function loadBills() {
    try {
        const response = await fetch(`${API_BASE_URL}/bill`);
        bills = await response.json();
        renderBillsTable();
    } catch (error) {
        console.error('Error loading bills:', error);
        alert('Error loading bills');
    }
}

function renderBillsTable() {
    const tbody = document.getElementById('billsTableBody');
    tbody.innerHTML = '';

    bills.forEach(bill => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${bill.id}</td>
            <td>${bill.patientId}</td>
            <td>$${bill.amount}</td>
            <td><span class="status-badge status-${bill.status.toLowerCase().replace('_', '-')}">${bill.status}</span></td>
            <td class="action-buttons">
                <button class="btn btn-warning btn-sm" onclick="editBill(${bill.id})">
                    <i class="fas fa-edit"></i> Edit
                </button>
                <button class="btn btn-danger btn-sm" onclick="deleteBill(${bill.id})">
                    <i class="fas fa-trash"></i> Delete
                </button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

async function handleBillSubmit(event) {
    event.preventDefault();

    const id = document.getElementById('billId').value;
    const bill = {
        patientId: parseInt(document.getElementById('billPatient').value),
        amount: parseFloat(document.getElementById('billAmount').value),
        status: document.getElementById('billStatus').value
    };

    try {
        let response;
        if (id) {
            response = await fetch(`${API_BASE_URL}/bill/${id}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(bill)
            });
        } else {
            response = await fetch(`${API_BASE_URL}/bill`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(bill)
            });
        }

        if (response.ok) {
            hideForm('bill');
            loadBills();
            alert(id ? 'Bill updated successfully!' : 'Bill added successfully!');
        } else {
            alert('Error saving bill');
        }
    } catch (error) {
        console.error('Error saving bill:', error);
        alert('Error saving bill');
    }
}

function editBill(id) {
    const bill = bills.find(b => b.id === id);
    if (bill) {
        document.getElementById('billId').value = bill.id;
        document.getElementById('billPatient').value = bill.patientId;
        document.getElementById('billAmount').value = bill.amount;
        document.getElementById('billStatus').value = bill.status;
        document.getElementById('bill-form-title').textContent = 'Edit Bill';
        document.getElementById('bill-form').style.display = 'block';
    }
}

async function deleteBill(id) {
    if (confirm('Are you sure you want to delete this bill?')) {
        try {
            const response = await fetch(`${API_BASE_URL}/bill/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                loadBills();
                alert('Bill deleted successfully!');
            } else {
                alert('Error deleting bill');
            }
        } catch (error) {
            console.error('Error deleting bill:', error);
            alert('Error deleting bill');
        }
    }
}

// Form management functions
function showAddForm(type) {
    const form = document.getElementById(`${type}-form`);
    const title = document.getElementById(`${type}-form-title`);

    // Reset form
    document.getElementById(`${type}Form`).reset();
    document.getElementById(`${type}Id`).value = '';

    title.textContent = `Add New ${type.charAt(0).toUpperCase() + type.slice(1)}`;
    form.style.display = 'block';

    // Update dropdowns for appointments and bills
    if (type === 'appointment' || type === 'bill') {
        updatePatientDropdowns();
        if (type === 'appointment') {
            updateDoctorDropdowns();
        }
    }
}

function hideForm(type) {
    document.getElementById(`${type}-form`).style.display = 'none';
}

// Update dropdown options
function updatePatientDropdowns() {
    const appointmentSelect = document.getElementById('appointmentPatient');
    const billSelect = document.getElementById('billPatient');

    [appointmentSelect, billSelect].forEach(select => {
        if (select) {
            select.innerHTML = '<option value="">Select Patient</option>';
            patients.forEach(patient => {
                const option = document.createElement('option');
                option.value = patient.id;
                option.textContent = `${patient.name} (ID: ${patient.id})`;
                select.appendChild(option);
            });
        }
    });
}

function updateDoctorDropdowns() {
    const doctorSelect = document.getElementById('appointmentDoctor');

    if (doctorSelect) {
        doctorSelect.innerHTML = '<option value="">Select Doctor</option>';
        doctors.forEach(doctor => {
            const option = document.createElement('option');
            option.value = doctor.id;
            option.textContent = `${doctor.name} - ${doctor.specialty} (ID: ${doctor.id})`;
            doctorSelect.appendChild(option);
        });
    }
}