import React from "react";
import { Form, Col } from "react-bootstrap";

function FileUpload({ controlId, label, handleFileChange }) {
  return (
    <Col md={6} className="file-upload-col">
      <Form.Group controlId={controlId}>
        <Form.Label>{label}</Form.Label>
        <Form.Control
          type="file"
          onChange={handleFileChange}
          accept=".csv"
          required
        />
      </Form.Group>
    </Col>
  );
}

export default FileUpload;
