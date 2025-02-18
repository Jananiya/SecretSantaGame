import React, { useState } from "react";
import axios from "axios";
import { Button, Form, Container, Row, Col, Alert, Spinner } from "react-bootstrap";
import './App.css'; 

function SecretSantaForm() {
  const [employeesFile, setEmployeesFile] = useState(null);
  const [previousAssignmentsFile, setPreviousAssignmentsFile] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(false);

  
  const handleEmployeesFileChange = (e) => {
    setEmployeesFile(e.target.files[0]);
  };

 
  const handlePreviousAssignmentsFileChange = (e) => {
    setPreviousAssignmentsFile(e.target.files[0]);
  };


  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!employeesFile || !previousAssignmentsFile) {
      setError("Please upload both files.");
      return;
    }

    const formData = new FormData();
    formData.append("employeesFile", employeesFile);
    formData.append("previousAssignmentsFile", previousAssignmentsFile);

    try {
      setLoading(true);
      setError(null);
      setSuccess(false);

     
      const response = await axios.post("http://localhost:8080/secret-santa/assign", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
        responseType: "blob", 
      });

      
      const url = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement("a");
      link.href = url;
      link.setAttribute("download", "secret_santa_assignments.csv"); 
      document.body.appendChild(link);
      link.click();
      link.remove();

      setSuccess(true);
      setLoading(false);
    } catch (error) {
      setLoading(false);
      setError("Error generating Secret Santa assignments.Please upload the file as CSV");
      console.error("Error during file upload or CSV download:", error);
    }
  };

  return (
    <Container className="my-5">
      <div className="text-center mb-4">
        <h1 className="page-title">Secret Santa Assignment Application</h1>
        <p className="sub-title">Upload the employee and previous assignment files to generate new Secret Santa assignments.</p>
      </div>

      {error && <Alert variant="danger">{error}</Alert>}
      {success && <Alert variant="success">Assignments generated successfully! Check your downloads.</Alert>}

      <Form onSubmit={handleSubmit} className="upload-form">
        <Row className="mb-4">
          <Col md={6} className="file-upload-col">
            <Form.Group controlId="employeesFile">
              <Form.Label>Employees File</Form.Label>
              <Form.Control
                type="file"
                onChange={handleEmployeesFileChange}
                accept=".csv"
                required
              />
            </Form.Group>
          </Col>
          <Col md={6} className="file-upload-col">
            <Form.Group controlId="previousAssignmentsFile">
              <Form.Label>Previous Assignments File</Form.Label>
              <Form.Control
                type="file"
                onChange={handlePreviousAssignmentsFileChange}
                accept=".csv"
                required
              />
            </Form.Group>
          </Col>
        </Row>

        <Button type="submit" variant="primary" block disabled={loading} className="submit-button">
          {loading ? (
            <>
              <Spinner as="span" animation="border" size="sm" role="status" aria-hidden="true" /> Generating...
            </>
          ) : (
            "Generate Assignments"
          )}
        </Button>
      </Form>
    </Container>
  );
}

export default SecretSantaForm;
