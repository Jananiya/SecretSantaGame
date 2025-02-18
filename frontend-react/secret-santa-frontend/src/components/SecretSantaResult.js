import React from "react";
import { Alert } from "react-bootstrap";

function SecretSantaResult({ success, error }) {
  return (
    <>
      {error && <Alert variant="danger">{error}</Alert>}
      {success && <Alert variant="success">Assignments generated successfully! Check your downloads.</Alert>}
    </>
  );
}

export default SecretSantaResult;
