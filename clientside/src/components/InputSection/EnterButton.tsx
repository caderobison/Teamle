import { Button } from "antd";
import React from "react";
interface IEnterButtonProps {
  fillWidth?: boolean;
  disabled?: boolean;
  loading?: boolean;
  onClick?: (event: React.MouseEvent<HTMLElement, MouseEvent>) => void;
  value: string;
}

export function EnterButton(props: IEnterButtonProps) {
  const { fillWidth, disabled, loading, onClick, value } = props;
  return (
    <Button
      block={fillWidth}
      disabled={disabled}
      loading={loading}
      onClick={onClick}
      color={"primary"}
      variant={"solid"}
    >
      {value}
    </Button>
  );
}
